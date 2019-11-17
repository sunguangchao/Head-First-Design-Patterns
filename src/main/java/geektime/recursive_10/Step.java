package geektime.recursive_10;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: sunguangchao
 * @Date: 2019/10/26 11:44 AM
 */
public class Step {
    private static Map<Integer, Integer> map = new ConcurrentHashMap<>();
    volatile static int depth = 1000;
    public static int getStepSum(int n) throws Exception{
        depth++;
        if (depth > 1000){
            throw new Exception("超过递归调用栈最大深度");
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        if (map.containsKey(n)){
            return map.get(n);
        }
        int value = getStepSum(n-1) + getStepSum(n-2);
        map.put(n, value);
        return value;
    }


    public static void main(String[] args) throws Exception{
        System.out.println(Step.getStepSum(19999999));
    }
}
