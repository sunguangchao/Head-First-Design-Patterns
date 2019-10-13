package pattern.observer.guava;


/**
 * Created by 11981 on 2019/10/13.
 */
public class Client {
    public static void main(String[] args) {
        WeChatAccounts accounts = new WeChatAccounts("sungc");


        WeChatClient use1 = new WeChatClient("张三");
        WeChatClient use2 = new WeChatClient("李四");
        WeChatClient use3 = new WeChatClient("王五");
        accounts.register(use1);
        accounts.register(use2);
        accounts.register(use3);

        accounts.publishArticles("观察者设计模式", "观察者设计模式的内容");
        accounts.unregister(use1);
        accounts.publishArticles("观察者设计模式3", "观察者设计模式的内容2");
    }
}
