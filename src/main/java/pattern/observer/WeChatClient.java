package pattern.observer;

/**
 * Created by 11981 on 2019/10/13.
 */
public class WeChatClient implements Subscriber {
    private String username;

    public WeChatClient(String username){
        this.username = username;
    }


    public int receive(String publisher, String articleName) {
        System.out.println(String.format("用户<%s>接收到<%s>微信公众号的推送，文章标题为<%s>", username, publisher, articleName));
        return 0;
    }
}
