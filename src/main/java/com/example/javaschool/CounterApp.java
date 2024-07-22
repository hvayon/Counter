package com.example.javaschool;

public class CounterApp {

    public static void main(String[] args) {
        Counter counter = new Counter("counter.tex");
        Console console = new Console(counter);
        console.start();
    }
}
