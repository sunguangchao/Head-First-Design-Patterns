package 设计模式之禅.proxy3;

public class BeforeAdvice implements IAdvice {
    @Override
    public void exec() {
        System.out.println("我是前置，我被执行了");
    }
}
