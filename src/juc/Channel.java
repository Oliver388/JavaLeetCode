package juc;

/**
 * @author linglifan
 * @date 2023/01/11 20:03
 */
public class Channel {
    private static final ThreadLocal<Message> THREAD_LOCAL = new ThreadLocal<Message>();

    public Channel() {
    }

    public static void setMessage(Message m){
        THREAD_LOCAL.set(m);
    }
    public static void send(){
        System.out.println("「" + Thread.currentThread().getName() + "、消息发送」" + THREAD_LOCAL.get().getInfo());
    }
}
