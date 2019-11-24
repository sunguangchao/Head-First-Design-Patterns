package 设计模式之禅.facede;

public class Facede {
    //被委托的对象
    private ClazzA clazzA = new ClazzA();
    private ClazzB clazzB = new ClazzB();
    private Context context = new Context();

    //提供给外部的访问方法

    public void methodA(){
        this.clazzA.doSomething();
    }

    public void methodB(){
        this.clazzB.doSomething();
    }

    public void methodC(){
        this.context.complexMethod();
    }
}
