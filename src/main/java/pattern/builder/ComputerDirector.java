package pattern.builder;

/**
 * Created by 11981 on 2019/10/17.
 */
public class ComputerDirector {
    public Computer construct(Builder builder){
        Computer computer;
        builder.buildBrand();
        builder.buildBrand();
        builder.buildCPU();
        builder.buildDisplayCard();
        builder.buildHardDisk();
        builder.buildMainBoard();
        builder.buildMemory();
        builder.buildPower();
        computer = builder.createComputer();
        return computer;
    }
}
