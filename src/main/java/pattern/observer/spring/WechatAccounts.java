package pattern.observer.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by 11981 on 2019/10/15.
 */
public class WechatAccounts implements ApplicationContextAware {
    private ApplicationContext context;

    private String name;

    public WechatAccounts(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }


    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void publishArticles(String articleName, String content){
        System.out.println(String.format("\n<%s>微信公众号 发布了一篇推送，文章名称为 <%s>，内容为 <%s> ", this.name, articleName, content));
        context.publishEvent(new WechatNotice(this.name, this.name, articleName));
    }
}
