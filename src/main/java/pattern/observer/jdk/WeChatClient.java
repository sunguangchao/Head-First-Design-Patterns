package pattern.observer.jdk;


import java.util.Observable;
import java.util.Observer;

/**
 * Created by 11981 on 2019/10/13.
 */
public class WeChatClient implements Observer {
    private String username;

    public WeChatClient(String username){
        this.username = username;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof WeChatNotice){
            WeChatNotice notice = (WeChatNotice)arg;
            System.out.println(String.format("用户<%s>接收到<%s>微信公众号的推送，文章标题为<%s>", username, notice.getPublisher(), notice.getArticleName()));
        }else {
            System.out.println("传入arg异常");
        }
    }
}
