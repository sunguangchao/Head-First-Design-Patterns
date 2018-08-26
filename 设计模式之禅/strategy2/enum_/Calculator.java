package design_pattern.strategy2.enum_;

/**
 * 策略枚举
 */
public enum Calculator {
    ADD("+"){
        @Override
        public int exec(int a, int b){
            return a + b;
        }
    },
    SUB("-"){
        @Override
        public int exec(int a, int b){
            return a + b;
        }
    };
    String value = "";
    //定义成员值类型
    private Calculator(String value){
        this.value = value;
    }
    //获得枚举成员的值
    public String getValue(){
        return this.value;
    }
    //声明一个抽象函数
    public abstract int exec(int a, int b);
}
