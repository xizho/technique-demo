package com.example.concurrent.pattern.balking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class BalkingData {

    private final String fileName;

    private String content;

    private boolean change;

    public BalkingData(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        this.change = true;
    }

    public synchronized void change(String content) {
        this.content = content;
        this.change = true;
    }

    public synchronized void save() {
        if (!change) {
            return;
        }

        doSave();
        this.change = false;
    }

    private void doSave() {
        System.out.println(Thread.currentThread().getName() + " calls do save, content is " + content);
        try (Writer writer = new FileWriter(fileName, true);) {
            writer.write(content);
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
