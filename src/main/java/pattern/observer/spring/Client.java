package pattern.observer.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 11981 on 2019/10/15.
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        WechatAccounts accounts = (WechatAccounts) context.getBean("WeChatAccounts");
        accounts.setName("小旋锋");
        accounts.setApplicationContext(context);

        accounts.publishArticles("设计模式 | 观察者模式及典型应用", "观察者模式的内容...");
    }
}
