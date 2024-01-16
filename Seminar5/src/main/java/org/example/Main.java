package org.example;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final ArrayList<Thread> philosophers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            philosophers.add(new Thread(new Philosophers(String.format("Philosopher: %d", i))));
        }

        for (int i = 0; i < philosophers.size(); i++) {
            philosophers.get(i).start();
        }

        for (int i = 0; i < philosophers.size(); i++) {
            waitForTaskFinished(philosophers.get(i));
        }
    }

    private static void waitForTaskFinished(final Thread ... threads) throws InterruptedException{
        for (final Thread thread: threads) {
            thread.join();
        }
    }
}


