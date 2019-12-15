package geektime.dynamic_40;

/**
 * @Author: sunguangchao
 * @Date: 2019/11/27 9:57 AM
 * 动态规划，解决0-1背包问题
 */
public class PackageProblemByDynamic {

    /**
     * @param weight 物品重量
     * @param n      物品个数
     * @param w      背包可承载重量
     * @return
     */
    public int knapsack(int[] weight, int n, int w) {
        /**
         * 行是物品个数
         * 列是物品重量
         * 重量要从0开始，所以需要w+1个
         */
        boolean[][] states = new boolean[n][w + 1];
        states[0][0] = true;
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                //不把第i个物品放入背包
                if (states[i - 1][j]) {
                    states[i][j] = states[i - 1][j];
                }
            }
            //把第i个物品放入背包
            for (int j = 0; j <= w - weight[i]; j++) {
                if (states[i - 1][j]) {
                    states[i][j + weight[i]] = true;
                }
            }
        }
        //打印矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (states[i][j]) {
                    System.out.print("*");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }

        /**
         * 返回最大物品的重量
         */
        for (int i = w; i >= 0; --i) {
            if (states[n - 1][i]) {
                return i;
            }
        }
        return 0;
    }


    /**
     * @param items
     * @param n
     * @param w
     * @return 优化内存占用
     */
    public int knapsack2(int[] items, int n, int w) {

        boolean[] status = new boolean[w + 1];
        //第一行需要特殊处理，利用哨兵优化
        status[0] = true;
        for (int i = 1; i < n; ++i) {
            for (int j = w - items[i]; j >= 0; --j) {
                if (status[j]) {
                    status[j + items[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; --i) {
            if (status[i]) {
                return i;
            }
        }
        return 0;

    }

    /**
     * 淘宝的“双十一”购物节有各种促销活动，比如“满 200 元减 50 元”。假设你女朋友的购物车中有 n 个（n>100）想买的商品，
     * 她希望从里面选几个，在凑够满减条件的前提下，让选出来的商品价格总和最大程度地接近满减条件（200 元），这样就可以极大限度地“薅羊毛”。
     */
    public static void double11Advance(int[] prices, int n, int total) {
        boolean[][] status = new boolean[n][3 * total + 1];
        //利用哨兵，解决第一行
        status[0][0] = true;
        if (prices[0] < total) {
            status[0][prices[0]] = true;
        }
        for (int i = 1; i < n; ++i) {
            //不将第i个物品放入购物车内
            for (int j = 0; j <= 3 * total; j++) {
                if (status[i - 1][j]) {
                    status[i][j] = true;
                }
            }
            //将第i个物品放入购物车内
            for (int j = 0; j < 3 * total - prices[i]; j++) {
                if (status[i - 1][j]) {
                    status[i][j + prices[i]] = true;
                }
            }
        }
        //找到最接近于total的结果result
        int result;
        for (result = total; result < 3 * total + 1; ++result) {
            if (status[n - 1][result]) {
                break;
            }
        }
        //没有可行性解
        if (result == 3 * total + 1) {
            return;
        }

        //打印矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 3 * total; j++) {
                if (status[i][j]) {
                    System.out.print("*");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
        //输出结果

        /**
         * 状态 (i, j) 只有可能从 (i-1, j) 或者 (i-1, j-value[i]) 两个状态推导过来。
         * 所以，我们就检查这两个状态是否是可达的，也就是 states[i-1][j] 或者 states[i-1][j-value[i]] 是否是 true。
         *
         * 如果 states[i-1][j] 可达，就说明我们没有选择购买第 i 个商品，
         * 如果 states[i-1][j-value[i]] 可达，那就说明我们选择了购买第 i 个商品。
         * 我们从中选择一个可达的状态（如果两个都可达，就随意选择一个）
         */
        for (int i = n - 1; i >= 1; --i) {
            if (result - prices[i] >= 0 && status[i - 1][result - prices[i]]) {
                System.out.println(prices[i] + " ");
                result -= prices[i];
            }
        }

        if (result != 0) System.out.print(prices[0]);
    }

    public static void main(String[] args) {
        int[] weight = {2, 2, 4, 6, 3};
        int n = 5;
        int w = 9;
        PackageProblemByDynamic dynamic = new PackageProblemByDynamic();
        int i = dynamic.knapsack(weight, n, 9);
        System.out.println(i);
        System.out.println(dynamic.knapsack2(weight, n, w));


        int[] prince = {10, 100, 20, 10, 30, 20, 100};
        int num = 7;
        int total = 200;
        System.out.println("--------------");
        PackageProblemByDynamic.double11Advance(prince, num, total);
    }
}
