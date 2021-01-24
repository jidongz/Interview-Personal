package program.multithread.SequentialPrint;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://blog.csdn.net/u013968384/article/details/82584944
 *
 * 三个线程按次序轮流打印a,b,c AtomicInteger 实现
 */

public class SequentialPrintByCAS {
    private static AtomicInteger currentCount = new AtomicInteger(0);
    private static final int MAX_COUNT = 30;
    private static String[] chars = {"a", "b", "c"};
    private String name;

    public SequentialPrintByCAS(String name) {
        this.name = name;
    }

    class Print implements Runnable {
        @Override
        public void run() {
            while (currentCount.get() < MAX_COUNT) {
                if (name.equals(chars[currentCount.get() % 3])) {
                    System.out.println(Thread.currentThread().getName() + " " + name + " " + currentCount);
                    currentCount.getAndIncrement();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10,
                20, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
        pool.execute(new SequentialPrintByCAS("a").new Print());
        pool.execute(new SequentialPrintByCAS("a").new Print());
        pool.execute(new SequentialPrintByCAS("b").new Print());
        pool.execute(new SequentialPrintByCAS("b").new Print());
        pool.execute(new SequentialPrintByCAS("c").new Print());
        pool.execute(new SequentialPrintByCAS("c").new Print());
        pool.shutdown();

//        new Thread(new SequentialPrintByCAS("a").new Print()).start();
//        new Thread(new SequentialPrintByCAS("a").new Print()).start();
//        new Thread(new SequentialPrintByCAS("b").new Print()).start();
//        new Thread(new SequentialPrintByCAS("b").new Print()).start();
//        new Thread(new SequentialPrintByCAS("c").new Print()).start();
//        new Thread(new SequentialPrintByCAS("c").new Print()).start();
    }
}
