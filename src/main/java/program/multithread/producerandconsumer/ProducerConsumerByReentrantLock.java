package program.multithread.producerandconsumer;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerByReentrantLock {
    private static int count = 0;
    private final static int FULL = 10;
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (count == FULL) {
                        notFull.await();
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + " produced 1 object, size: " + count);
                    Thread.sleep(new Random().nextInt(1000) + 500);
                    notEmpty.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (count == 0) {
                        notEmpty.await();
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + " consumed 1 object, size: " + count);
                    Thread.sleep(new Random().nextInt(1000) + 500);
                    notFull.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumerByReentrantLock sample = new ProducerConsumerByReentrantLock();
        new Thread(sample.new Producer()).start();
        new Thread(sample.new Producer()).start();
        new Thread(sample.new Producer()).start();
        new Thread(sample.new Consumer()).start();
    }
}
