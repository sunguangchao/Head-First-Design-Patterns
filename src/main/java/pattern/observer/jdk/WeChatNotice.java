package pattern.observer.jdk;

/**
 * Created by 11981 on 2019/10/13.
 * 在JDK的 java.util 包中，提供了 Observable 类以及 Observer 接口，它们构成了JDK对观察者模式的支持。
 */

public class WeChatNotice {
    private String publisher;

    private String articleName;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }


    public WeChatNotice(String publisher, String articleName) {
        this.publisher = publisher;
        this.articleName = articleName;
    }
}
