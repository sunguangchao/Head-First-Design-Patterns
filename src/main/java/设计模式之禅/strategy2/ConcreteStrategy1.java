package 设计模式之禅.strategy2;

public class ConcreteStrategy1 implements Strategy {
    @Override
    public void doSomething(){
        System.out.println("具体策略1的运算法则");
    }
}
