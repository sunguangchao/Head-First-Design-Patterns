package pattern.observer.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import pattern.observer.guava.WeChatClient;
import pattern.observer.jdk.WeChatNotice;

/**
 * Created by 11981 on 2019/10/15.
 */
public class WechatClient implements ApplicationListener {

    private String username;

    public WechatClient(String username){
        this.username = username;
    }

    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof WechatNotice){
            WechatNotice notice = (WechatNotice) applicationEvent;
            System.out.println(String.format("用户<%s> 接收到 <%s>微信公众号 的推送，文章标题为 <%s>", username, notice.getPublisher(), notice.getArticleName()));

        }
    }

    public void setUsername(String username){
        this.username = username;
    }
}
