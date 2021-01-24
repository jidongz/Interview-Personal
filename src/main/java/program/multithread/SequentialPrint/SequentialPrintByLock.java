package program.multithread.SequentialPrint;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SequentialPrintByLock {
    private static Lock lock = new ReentrantLock();
    private static int currentCount = 0;
    private static final int MAX_COUNT = 30;
    private static String[] chars = {"a", "b", "c"};
    private String name;

    public SequentialPrintByLock(String name) {
        this.name = name;
    }

    class Print implements Runnable {
        @Override
        public void run() {
            while (currentCount < MAX_COUNT) {
                try {
                    lock.lock();
                    while (name.equals(chars[currentCount % 3]) && currentCount < MAX_COUNT) {
                        System.out.println(Thread.currentThread().getName() + " " + name + " " + currentCount);
                        currentCount++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10,
                20, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
        pool.execute(new SequentialPrintByLock("a").new Print());
        pool.execute(new SequentialPrintByLock("a").new Print());
        pool.execute(new SequentialPrintByLock("b").new Print());
        pool.execute(new SequentialPrintByLock("b").new Print());
        pool.execute(new SequentialPrintByLock("c").new Print());
        pool.execute(new SequentialPrintByLock("c").new Print());
        pool.shutdown();
    }
}
