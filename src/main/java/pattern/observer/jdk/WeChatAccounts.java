package pattern.observer.jdk;



import java.util.Observable;

/**
 * Created by 11981 on 2019/10/13.
 */
public class WeChatAccounts extends Observable {
    private String name;


    public WeChatAccounts(String name){
        this.name = name;
    }


    public void publishArticles(String articleName, String content){
        System.out.println(String.format("<%s>微信公众号，发布了一篇推送，文章名称为<%s>，内容为<%s>", name, articleName, content));
        setChanged();
        notifyObservers(new WeChatNotice(this.name, articleName));
    }
}
