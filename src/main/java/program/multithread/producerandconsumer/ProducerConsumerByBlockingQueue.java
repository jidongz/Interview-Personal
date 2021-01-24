package program.multithread.producerandconsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * https://blog.csdn.net/wowwilliam0/article/details/80875673
 */

public class ProducerConsumerByBlockingQueue {
    private BlockingQueue<Object> queue = new ArrayBlockingQueue(10);

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    queue.put(new Object());
                    System.out.println(Thread.currentThread().getName()
                            + " produced 1 object, queue size: " + queue.size());

                    Thread.sleep(new Random().nextInt(1000) + 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    queue.take();
                    System.out.println(Thread.currentThread().getName()
                            + " consumed 1 object, queue size: " + queue.size());

                    Thread.sleep(new Random().nextInt(1000) + 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumerByBlockingQueue sample = new ProducerConsumerByBlockingQueue();
        new Thread(sample.new Producer()).start();
        new Thread(sample.new Producer()).start();
        new Thread(sample.new Producer()).start();
        new Thread(sample.new Consumer()).start();
    }
}
