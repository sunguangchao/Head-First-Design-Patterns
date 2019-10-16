package pattern.builder;

/**
 * Created by 11981 on 2019/10/17.
 */
public class Client {
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();

        Builder asusBuilder = new AsusComputerBuilder();
        Computer asusComputer = director.construct(asusBuilder);
        System.out.println(asusComputer.toString());


        Builder dellBuilder = new DellComputerBuilder();
        Computer dellComputer = director.construct(dellBuilder);
        System.out.println(dellComputer.toString());
    }
}
