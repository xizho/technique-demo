package com.example.rpc.server.provider;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xizho
 */
public class RpcServerForContainer implements ApplicationContextAware, InitializingBean {

    private ExecutorService executorService = Executors.newCachedThreadPool();

    private Map<String, Object> handlerMap = new HashMap<>();

    private int port;

//    public RpcServerForContainer() {}

    public RpcServerForContainer(int port) {
        this.port = port;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("发布服务[" + handlerMap.keySet() + "]到端口：" + port);
        System.out.println();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcessorHandler(handlerMap, socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> beansMap = applicationContext.getBeansWithAnnotation(RpcService.class);
        if (!beansMap.isEmpty()) {
            for (Object bean : beansMap.values()) {
                RpcService rpcService = bean.getClass().getAnnotation(RpcService.class);
                String name = rpcService.value().getName();
                String version = rpcService.version();
                if (!StringUtils.isEmpty(version)) {
                    name += "-" + version;
                }

                handlerMap.put(name, bean);
            }
        }
    }

}
