package design_pattern.proxy;

/**
 * @author sunguangchao
 * 总结一下，代理模式主要使用了Java的多态，干活的是被代理类，代理类主要是接活
 * 你让我干活，好，我交给幕后的类去干，你满意就成，那怎么知道代理类能不能干呢？
 * 同根就成，大家知根知底，你能做啥，我能做啥都清楚的很，同一个接口呗。
 */
public class XiMenQing {
    public static void main(String[] args) {
        WangPo wangPo = new WangPo();
        wangPo.makeEyesWithMan();
        wangPo.happyWithMan();
    }
}
