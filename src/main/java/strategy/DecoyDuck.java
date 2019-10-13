package strategy;

/**
 * Created by 11981 on 2017/9/26.
 */
public class DecoyDuck extends Duck {
    public DecoyDuck(){
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new MuteQuack());
    }

    public void display(){
        System.out.println("I'm a duck Decoy");
    }
}
