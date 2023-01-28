package threadpool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author linglifan
 * @date 2023/01/12 15:48
 */
public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        List<Future<String>> futureList = new ArrayList<>();
        MyRunnable thread = new MyRunnable();
        for (int i = 0; i < 10; i++) {
            Future<String> future = executor.submit(thread);
            futureList.add(future);
        }
        for (Future<String> stringFuture : futureList) {
            try {
                System.out.println(new Date() + "::" + stringFuture.get());
            } catch (InterruptedException|ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }
}
