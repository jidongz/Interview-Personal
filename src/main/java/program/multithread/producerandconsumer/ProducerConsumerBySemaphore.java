package program.multithread.producerandconsumer;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ProducerConsumerBySemaphore {
    private static int count = 0;
    Semaphore notFull = new Semaphore(10);
    Semaphore notEmpty = new Semaphore(0);

    //final Semaphore mutex = new Semaphore(1);

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    notFull.acquire();
                    //mutex.acquire();
                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + " produced 1 object, size: " + count);
                    //Thread.sleep(new Random().nextInt(1000) + 500);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //mutex.release();
                    notEmpty.release();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    notEmpty.acquire();
                    //mutex.acquire();
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + " consumed 1 object, size: " + count);
                    //Thread.sleep(new Random().nextInt(1000) + 500);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //mutex.release();
                    notFull.release();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumerBySemaphore sample = new ProducerConsumerBySemaphore();
        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(sample.new Producer());
        service.execute(sample.new Producer());
        service.execute(sample.new Producer());
        service.execute(sample.new Consumer());
    }
}
