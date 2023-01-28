package juc;

/**
 * @author linglifan
 * @date 2023/01/11 20:22
 */
public class demo {
    public static void main(String[] args) {
        new Thread(() -> {
            Message m = new Message();
            m.setInfo("线程a消息：我爱吃屎");
            Channel.setMessage(m);
            Channel.send();
        }).start();
        new Thread(() ->{
            Message m = new Message();
            m.setInfo("线程b消息：我爱喝尿");
            Channel.setMessage(m);
            Channel.send();
        }).start();
    }
}
