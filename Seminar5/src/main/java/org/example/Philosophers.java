package org.example;

public class Philosophers implements Runnable {
    private final String name;
    private final int TIME_WAITING_IN_MILIS = 500;
    private final int EATING_TIMES = 3;

    public Philosophers(String name) {
        this.name = name;
    }

    private void dinning() throws InterruptedException {
        Thread.sleep(TIME_WAITING_IN_MILIS);
        System.out.printf("%s ate his dinner.\n", name);
    }

    public void acting() throws InterruptedException {
        for (int i = 0; i < EATING_TIMES; i++) {
            dinning();
            thinking();
        }
    }
    private void thinking(){
        System.out.printf("%s is thinking.\n", name);
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        try {
            acting();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
