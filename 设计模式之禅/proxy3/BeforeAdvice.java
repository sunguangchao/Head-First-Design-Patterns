package design_pattern.proxy3;

public class BeforeAdvice implements IAdvice {
    @Override
    public void exec() {
        System.out.println("我是前置，我被执行了");
    }
}
