package strategy;

/**
 * Created by 11981 on 2017/9/26.
 * 由行为类来实现接口
 */
public class FlyNoWay implements FlyBehavior {
    public void fly(){
        System.out.println("I can't fly");
    }
}
