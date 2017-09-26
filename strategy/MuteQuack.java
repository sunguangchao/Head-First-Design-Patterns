package strategy;

/**
 * Created by 11981 on 2017/9/26.
 */
public class MuteQuack implements QuackBehavior {
    public void quack(){
        System.out.println("<< Silence >>");
    }
}
