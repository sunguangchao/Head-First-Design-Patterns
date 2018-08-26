package design_pattern.proxy2;

public interface IGamePlayer {
    void killBoss();
    void login(String user, String password);
    void upgrade();
    IGamePlayer getProxy();
}
