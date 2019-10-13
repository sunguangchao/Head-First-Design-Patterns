package pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 11981 on 2019/10/13.
 * 发布者类：维护了一个订阅者列表，实现了
 */
public class Publisher {
    private List<Subscriber> subscribers;


    private boolean pubStatus = false;


    public Publisher(){
        subscribers = new ArrayList<Subscriber>();
    }

    protected void subscribe(Subscriber subscriber){
        this.subscribers.add(subscriber);
    }


    protected void unsubscribe(Subscriber subscriber){
        if (this.subscribers.contains(subscriber)){
            this.subscribers.remove(subscriber);
        }
    }


    /**
     * 通知所有关注者
     * @param publisher
     * @param articleName
     */
    protected void notifySubscribers(final String publisher, final String articleName){
        if (this.pubStatus == false){
            return;
        }
        this.subscribers.forEach(s -> s.receive(publisher, articleName));
        this.clearPubStatus();
    }

    protected void setPubStatus(){
        this.pubStatus = true;
    }

    protected void clearPubStatus(){
        this.pubStatus = false;
    }
}
