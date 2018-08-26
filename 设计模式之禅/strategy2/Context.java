package design_pattern.strategy2;

/**
 * 封装角色
 */
public class Context {
    //抽象策略
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void doSomething(){
        this.strategy.doSomething();
    }
}
