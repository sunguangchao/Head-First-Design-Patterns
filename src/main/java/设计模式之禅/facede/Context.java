package 设计模式之禅.facede;

public class Context {
    private ClazzA clazzA = new ClazzA();
    private ClazzC clazzC = new ClazzC();

    public void complexMethod(){
        this.clazzA.doSomething();
        this.clazzC.doSomething();
    }
}
