package pattern.observer.spring;

import org.springframework.context.ApplicationEvent;

/**
 * Created by 11981 on 2019/10/15.
 */
public class WechatNotice extends ApplicationEvent{
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

    public WechatNotice(Object source, String publisher, String articleName) {
        super(source);
        this.publisher = publisher;
        this.articleName = articleName;
    }
}
