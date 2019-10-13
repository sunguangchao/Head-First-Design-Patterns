package pattern.observer.guava;


import com.google.common.eventbus.EventBus;
import pattern.observer.jdk.WeChatNotice;

/**
 * Created by 11981 on 2019/10/13.
 */
public class WeChatAccounts{
    private String name;
    private EventBus eventBus;


    public WeChatAccounts(String name){
        this.name = name;
        this.eventBus = new EventBus();
    }


    public void publishArticles(String articleName, String content){
        System.out.println(String.format("<%s>微信公众号，发布了一篇推送，文章名称为<%s>，内容为<%s>", this.name, articleName, content));
        this.eventBus.post(new WeChatNotice(this.name, articleName));
    }

    public void register(WeChatClient weChatClient){
        this.eventBus.register(weChatClient);
    }

    public void unregister(WeChatClient weChatClient){
        this.eventBus.unregister(weChatClient);
    }
}
