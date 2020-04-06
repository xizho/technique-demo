package com.example.design.pattern.singleton;

import com.example.design.pattern.singleton.singletons.serializable.SerializableSingleton;

import java.io.*;

public class SerializableSingletonTest {
    public static void main(String[] args) {
        SerializableSingleton s1 = SerializableSingleton.getInstance();
        SerializableSingleton s2 = null;

        try (FileOutputStream   fos = new FileOutputStream("SerializableSingleton.obj");
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             FileInputStream    fis = new FileInputStream("SerializableSingleton.obj");
             ObjectInputStream  ois = new ObjectInputStream(fis)) {

            oos.writeObject(s1);
            oos.flush();

            // TODO 研究源码
            s2 = (SerializableSingleton) ois.readObject();
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
