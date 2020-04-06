package com.example.other.test.jvm;

import java.io.IOException;
import java.io.InputStream;

public class DiffClassLoader {
    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader();
        Object obj = myClassLoader.loadClass("com.example.other.test.jvm.DiffClassLoader").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj.getClass().getClassLoader());
        System.out.println(obj.getClass().getClassLoader().getParent());
        System.out.println(obj.getClass().getClassLoader().getParent().getParent());
        System.out.println(obj.getClass().getClassLoader().getParent().getParent().getParent());
        System.out.println(obj instanceof DiffClassLoader);
    }

    static class MyClassLoader extends ClassLoader {
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
            InputStream is = getClass().getResourceAsStream(fileName);
            if (is == null) {
                return super.loadClass(name);
            }

            try {
                byte[] bytes = new byte[is.available()];
                is.read(bytes);
                return defineClass(name, bytes, 0, bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return super.loadClass(name);
        }
    }
}
