package 设计模式之禅.proxy;

public class PanJinLian implements KindWomen {
    @Override
    public void makeEyesWithMan() {
        System.out.println("潘金莲抛媚眼");
    }

    @Override
    public void happyWithMan() {
        System.out.println("潘金莲在和...");
    }
}
