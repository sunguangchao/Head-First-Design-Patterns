package design_pattern.facede;

public class Context {
    private ClazzA clazzA = new ClazzA();
    private ClazzC clazzC = new ClazzC();

    public void complexMethod(){
        this.clazzA.doSomething();
        this.clazzC.doSomething();
    }
}
