package thread.start.test;

import static util.MyLogger.log;

public class ManyThreadTest {
    public static void main(String[] args) {
        new Thread(new PrintWork("A", 1000)).start();
        new Thread(new PrintWork("B", 500)).start();
    }

    static class PrintWork implements Runnable {
        private String content;
        private int sleepMs;

        public PrintWork(String content, int sleepMs) {
            this.content = content;
            this.sleepMs = sleepMs;
        }

        @Override
        public void run() {
            while (true) {
                log("value: " + content);
                try {
                    Thread.sleep(sleepMs);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
