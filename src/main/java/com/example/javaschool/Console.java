package com.example.javaschool;

import java.util.Scanner;

public class Console {
    private Counter counter;

    public Console(Counter counter) {
        this.counter = counter;
    }
    public void start() {

        System.out.println("Приложение запущено.");
        Scanner in = new Scanner(System.in);

        label:
        while (true) {
            System.out.print("Введите команду: ");
            String input = in.nextLine();
            switch (input) {
                case "/inc":
                    System.out.println("Счетчик увеличен");
                    counter.increment();
                    System.out.println("Значение счетчика обновлено:" + "'" + counter.getValue() + "'");
                    break;
                case "/stop":
                    System.out.println("Текущее значение счетчика: " + "'" + counter.getValue() + "'");
                    counter.doSerialization();
                    System.out.println("Завершаю работу");
                    break label;
                case "/reset":
                    System.out.println("Счетчик обнулён.");
                    counter.reset();
                    System.out.println("Текущее значение счетчика: " + "'" + counter.getValue() + "'");
                    break;
                default:
                    System.out.println("Неизвестная команда");
                    break;
            }
        }
    }
}
