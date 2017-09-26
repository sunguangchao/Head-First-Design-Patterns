package strategy;

/**
 * Created by 11981 on 2017/9/26.
 */
public class RedHeadDuck extends Duck{
    public RedHeadDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    public void display(){
        System.out.println("I'm a real Red Headed duck");
    }
}
