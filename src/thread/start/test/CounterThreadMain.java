package thread.start.test;

import static util.MyLogger.log;

public class CounterThreadMain {
    public static void main(String[] args) {
        new CounterThread().start();
    }

    static class CounterThread extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                log("value: " + i);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}