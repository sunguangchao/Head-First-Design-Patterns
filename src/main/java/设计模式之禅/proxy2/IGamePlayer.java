package 设计模式之禅.proxy2;

public interface IGamePlayer {
    void killBoss();
    void login(String user, String password);
    void upgrade();
    IGamePlayer getProxy();
}
