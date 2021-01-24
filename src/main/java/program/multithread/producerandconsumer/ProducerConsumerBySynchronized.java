package program.multithread.producerandconsumer;

import java.util.Random;

/**
 * https://blog.csdn.net/wowwilliam0/article/details/80875673
 */

public class ProducerConsumerBySynchronized {
    private static int count = 0;
    private final static int FULL = 10;
    private final static Object LOCK = new Object();

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (LOCK) {
                    while (count == FULL) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + " produced 1 object, size: " + count);
                    try {
                        Thread.sleep(new Random().nextInt(1000) + 500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    LOCK.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + " consumed 1 object, size: " + count);
                    try {
                        Thread.sleep(new Random().nextInt(1000) + 500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumerBySynchronized sample = new ProducerConsumerBySynchronized();
        new Thread(sample.new Producer()).start();
        new Thread(sample.new Producer()).start();
        new Thread(sample.new Producer()).start();
        new Thread(sample.new Consumer()).start();
    }
}
