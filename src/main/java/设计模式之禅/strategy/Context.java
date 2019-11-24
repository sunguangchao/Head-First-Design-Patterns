package 设计模式之禅.strategy;

/**
 * @author sunguangchao
 * 计谋有了，那还要有锦囊
 */
public class Context {
    //构造函数，你要使用那个妙计
    private IStrategy strategy;
    public Context(IStrategy strategy){
        this.strategy = strategy;
    }

    public void operate(){
        this.strategy.operate();
    }
}
