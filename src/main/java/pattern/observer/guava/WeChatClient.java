package pattern.observer.guava;

import com.google.common.eventbus.Subscribe;
import pattern.observer.jdk.WeChatNotice;

/**
 * Created by 11981 on 2019/10/13.
 */
public class WeChatClient {
    private String username;

    public WeChatClient(String username){
        this.username = username;
    }


    @Subscribe
    public void listen(WeChatNotice notice) {
        System.out.println(String.format("用户<%s>接收到<%s>微信公众号的推送，文章标题为<%s>", username, notice.getPublisher(), notice.getArticleName()));
    }
}
