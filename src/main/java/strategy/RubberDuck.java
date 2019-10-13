package strategy;

/**
 * Created by 11981 on 2017/9/26.
 */
public class RubberDuck extends Duck {
    public RubberDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }

    public void display(){
        System.out.println("I'm a rubber duckie");
    }

}
