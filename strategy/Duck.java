package strategy;

/**
 * Created by 11981 on 2017/9/26.
 * 抽象类的作用
 * 继承抽象类可以继承到抽象类的那些域
 */
public abstract class Duck {

    /**
     * 找出类中可能变化的部分，把他们独立出来
     * 不要和那些不需要变化的代码混在一起
     * 这里FlyBehavior和QuackBehavior
     * 就是分离出去的行为
     */
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb){
        quackBehavior = qb;
    }

    abstract void display();

    //用preform方法来代替原来的fly()和quack()方法
    //鸭子对象不亲自处理飞行行为，而是委托给flyBehavior引用的对象
    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("All ducks float, even decoys");
    }

}
