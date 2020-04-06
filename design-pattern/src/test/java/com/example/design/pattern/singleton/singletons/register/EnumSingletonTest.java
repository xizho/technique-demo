package com.example.design.pattern.singleton.singletons.register;

import java.io.*;

public class EnumSingletonTest {

    public static void main(String[] args) {
        EnumSingleton s1 = EnumSingleton.getInstance();
        EnumSingleton s2 = null;

        try (FileOutputStream fos = new FileOutputStream("EnumSingleton.obj");
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             FileInputStream fis = new FileInputStream("EnumSingleton.obj");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            oos.writeObject(s1);
            oos.flush();

            // TODO 研究源码
            s2 = (EnumSingleton) ois.readObject();
            System.out.println(s1);
            System.out.println(s2);

            System.out.println(s1 == s2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}