package pattern.adapter;

/**
 * Created by 11981 on 2018/5/13.
 */
public class Client {
    public static void main(String[] args) {
        ScoreOperation operation;//针对接口编程
        operation = (ScoreOperation) XMLUtil.getBean();
        int sorces[] = {84, 76, 50, 69, 47, 11, 99};
        int result[];
        int sorce;
        System.out.println("成绩排序结果：");
        result = operation.sort(sorces);
        for (int i : sorces){
            System.out.print(i+",");
        }
        System.out.println("查找成绩为99");
        sorce = operation.search(result, 99);
        System.out.println("位置：" + sorce);
    }
}
