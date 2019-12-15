package geektime.dynamic_40;

/**
 * @Author: sunguangchao
 * @Date: 2019/11/29 7:52 PM
 * 我们现在引入物品价值这一变量。对于一组不同重量、不同价值、不可分割的物品，我们选择将某些物品装入背包，在满足背包最大重量限制的前提下，背包中可装入物品的总价值最大是多少呢？
 */
public class PackageAndValueProblem {
    // 结果放到maxV中
    public static int maxV = Integer.MIN_VALUE;
    /**
     * 物品的重量
     */
    public static int[] items = {2,2,4,6,3};
    /**
     * 物品的价值
     */
    public static int[] value = {3,4,8,9,6};
    public static int n = 5; // 物品个数
    public static int w = 9; // 背包承受的最大重量


    /**
     * 回溯算法
     * 一定要考虑结束条件
     * @param i
     * @param cw
     * @param cv
     */
    public void f(int i, int cw, int cv){
        //cw==w表示装满了，i==n表示物品都考察完了
        if (i == n || cw == w){
            if (cv > maxV){
                maxV = cv;
            }
            //一开始没加return,
            return;
        }
        //选择不装第i个物品
        f(i+1, cw, cv);
        if (cw + items[i] <= w){
            //选择装第i个物品
            f(i+1, cw+items[i], cv+value[i]);
        }
    }


    /**
     *
     * @param weight 每个物品的重量
     * @param value 每个物品的价值
     * @param n 物品个数
     * @param w 总重量
     * @return
     */
    public static int knapsack3(int[] weight, int[] value, int n, int w){
        /**
         * 存储当前对应的最大价值
         */
        int[][] status = new int[n][w+1];
        //初始化数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w+1; j++) {
                status[i][j] = -1;
            }
        }
        status[0][0] = 0;
        if (weight[0] < w){
            status[0][weight[0]] = value[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < w+1; j++) {
                //不把第i个物品放入背包
                if (status[i-1][j] >= 0){
                    status[i][j] = status[i-1][j];
                }
            }
            //把第i个物品放入背包
            for (int j = 0; j <= w-weight[i]; j++) {
                if (status[i-1][j] >= 0){
                    int v = status[i-1][j] + value[i];
                    if (v > status[i][j+weight[i]]){
                        status[i][j+weight[i]] = v;
                    }
                }
            }
        }
        //打印结果
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                System.out.print(status[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        int maxValue = -1;
        for (int j = 0; j <=n ; j++) {
            if (status[n-1][j] > maxValue){
                maxValue = status[n-1][j];
            }
        }
        return maxValue;
    }




    public static void main(String[] args) {
        PackageAndValueProblem problem = new PackageAndValueProblem();
        problem.f(0,0,0);
        int maxValue = PackageAndValueProblem.knapsack3(PackageAndValueProblem.items, PackageAndValueProblem.value, n, w);
        System.out.println(maxValue);
    }
}
