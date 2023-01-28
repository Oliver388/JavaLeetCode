package threadpool;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author linglifan
 * @date 2023/01/12 15:45
 */
public class MyRunnable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }
}
