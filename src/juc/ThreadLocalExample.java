package juc;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @author linglifan
 * @date 2023/01/11 21:14
 */
public class ThreadLocalExample implements Runnable{

    private static final ThreadLocal<SimpleDateFormat> FORMAT_THREAD_LOCAL = new ThreadLocal<SimpleDateFormat>();
    public static void main(String[] args) throws InterruptedException{
        ThreadLocalExample example = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(example, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            thread.start();
        }
    }
    @Override
    public void run() {
        System.out.println("Thread Name= "+Thread.currentThread().getName()+
                " default Formatter = "+FORMAT_THREAD_LOCAL.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        FORMAT_THREAD_LOCAL.set(new SimpleDateFormat());

        System.out.println("Thread Name= "+Thread.currentThread().getName()+
                " formatter = "+FORMAT_THREAD_LOCAL.get().toPattern());
    }
}
