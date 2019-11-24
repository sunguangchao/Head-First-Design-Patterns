package 设计模式之禅.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        IGamePlayer player = new GamePlayer("张三封");
//        IGamePlayer proxy = player.getProxy();
        InvocationHandler handler = new GamePlayIH(player);
        ClassLoader classLoader = player.getClass().getClassLoader();
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(classLoader, new Class[]{IGamePlayer.class},handler);
        proxy.login("zhangsan", "Password");
        proxy.killBoss();
        proxy.upgrade();
    }
}
