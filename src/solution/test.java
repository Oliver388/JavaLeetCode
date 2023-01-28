package solution;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author linglifan
 * @date 2023/01/10 15:59
 */
public class test {
    volatile static int inc = 0;

    Lock lock = new ReentrantLock();
    public void increase() {
        lock.lock();
        try {
            inc++;
        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        test test = new test();
        for (int i = 0; i < 5; i++) {
            threadPool.submit(() -> {
                for (int j = 0; j < 500; j++) {
                    test.increase();
                }
            });
        }

        Thread.sleep(1500);
        System.out.println(inc);
        threadPool.shutdown();

    }
}
