package com.example.web;

import com.example.web.config.annotation.InstanceSelf;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xizho
 */
@RestController
@SpringBootApplication
public class WebDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebDemoApplication.class, args);

    }

    @GetMapping("/hello")
    public String index() {
        return "Hello Xizho!";
    }

    public static Map<String, Object> instanceMap = new ConcurrentHashMap<>();


    @PostConstruct
    public void init() {
        String webDemoApplication = WebDemoApplication.class.getName();
        String packagePath = StringUtils.substringBeforeLast(webDemoApplication, ".");

        packagePath = packagePath.replaceAll("\\.", "/");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            Enumeration<URL> resources = classLoader.getResources(packagePath);
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                String protocol = url.getProtocol();

                if ("file".equals(protocol)) {
                    getClassFiles(url.getPath(), new ArrayList<>()).stream()
                            .map(File::getAbsolutePath).collect(Collectors.toList())
                            .stream().filter(fileName -> fileName.endsWith(".class"))
                            .forEach(fileName -> {
                                String classPath = StringUtils.substringAfter(fileName, "classes" + File.separator);
                                String className = StringUtils.replace(classPath, File.separator, ".");
                                className = StringUtils.substringBeforeLast(className, ".");

                                try {
                                    Class<?> klass = Class.forName(className);
                                    Stream.of(klass.getDeclaredFields())
                                            .filter(field -> null != field.getAnnotation(InstanceSelf.class))
                                            .forEach(field -> {
                                                Class<?> type = field.getType();
                                                try {
                                                    Object instance = type.newInstance();
                                                    field.setAccessible(true);
                                                    // TODO 此处应该取容器中的bean，然后遍历出bean中的Field，然后用自定义的注解初始化，此时赋值应该会成功

                                                    instanceMap.put(type.getName(), instance);
                                                } catch (InstantiationException | IllegalAccessException e) {
                                                    e.printStackTrace();
                                                }
                                            });
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                            });
                } else if ("jar".equals(protocol)) {
                    // TODO JAR
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("自定义初始化的实例为：" + instanceMap);
    }

    public List<File> getClassFiles(String packagePath, List<File> classFiles) {
        File[] files = new File(packagePath).listFiles();

        for (File file : files != null ? files : new File[0]) {
            if (file.isDirectory()) {
                getClassFiles(file.getPath(), classFiles);
            } else {
                classFiles.add(file);
            }
        }

        return classFiles;
    }

}
