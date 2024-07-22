package com.example.javaschool;

import java.io.*;

public class Counter implements Serializable {
    private int value;
    private String filename;

    public Counter(String filename) {
        this.filename = filename;
        checkFile();
    }

    public int getValue() {
        return value;
    }

    public void increment() {
        value++;
    }

    public void reset() {
        value = 0;
    }

    void doSerialization() {
        try (FileOutputStream fileOutput = new FileOutputStream(filename)) {
            ObjectOutputStream out = new ObjectOutputStream(fileOutput);
            out.writeInt(value);
            out.close();
            System.out.println("Состояние счетчика сохранено");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении состояния счетчика: " + e.getMessage());
        }
    }

    void doDeserialization() {
        try (FileInputStream fileInput = new FileInputStream(filename)) {
            ObjectInputStream in = new ObjectInputStream(fileInput);
            value = in.readInt();
            System.out.println("Счетчик загружен, значение " + "'" + value + "'");
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка при загрузке состояния счетчика: " + e.getMessage());
        }
    }

    public void checkFile() {
        File file = new File(filename);
        if (file.length() != 0) {
            doDeserialization();
        } else {
            System.out.println("Текущее значение: 0");
        }
    }

}

