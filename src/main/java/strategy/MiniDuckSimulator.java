package strategy;

/**
 * Created by 11981 on 2017/9/26.
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        MallardDuck mallard = new MallardDuck();
        RubberDuck rubberDuck = new RubberDuck();
        DecoyDuck decoyDuck = new DecoyDuck();

        Duck model = new ModelDuck();

        mallard.performQuack();
        mallard.performFly();
        rubberDuck.performQuack();
        decoyDuck.performQuack();

        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
