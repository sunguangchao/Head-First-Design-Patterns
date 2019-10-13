package pattern.observer;

/**
 * Created by 11981 on 2019/10/13.
 */
public interface Subscriber {
    /**
     * 接收消息推送的方法
     * @param publisher
     * @param articleName
     * @return
     */
    int receive(String publisher, String articleName);
}
