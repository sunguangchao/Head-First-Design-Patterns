package 设计模式之禅.proxy;

public class WangPo implements KindWomen {
    private KindWomen kindWomen;


    public WangPo(){
        //默认的话，是潘金莲的代理
        this.kindWomen = new PanJinLian();
    }
    public WangPo(KindWomen kindWomen){
        //她可以是KindWomen的任何一个女人的代理，只要你是这一类型
        this.kindWomen = kindWomen;
    }
    @Override
    public void makeEyesWithMan() {
        //自己老了，干不了，可以让年轻的代替
        this.kindWomen.makeEyesWithMan();
    }

    @Override
    public void happyWithMan() {
        //王婆这么大年龄了，谁看她抛媚眼？！
        this.kindWomen.happyWithMan();
    }
}
