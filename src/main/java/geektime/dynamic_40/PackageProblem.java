package geektime.dynamic_40;

/**
 * @Author: sunguangchao
 * @Date: 2019/11/27 9:37 AM
 * 回溯算法
 * 对于一组不同重量、不可分割的物品，我们需要选择一些装入背包，在满足背包最大重量限制的前提下，背包中物品总重量的最大值是多少呢？
 * 说实话，我这没看懂
 */
public class PackageProblem {
    private int maxW = Integer.MIN_VALUE;
    private int[] weight = {2,2,4,6,3};
    private int n = 5;
    private int w = 9;
    private boolean[][] mem = new boolean[5][10];

    public void f(int i, int currentWeight){
        System.out.println("f=" + i + "cw=" + currentWeight);
        //cw=w表示装满了，i=n表示考察完了
        if (currentWeight == w || i== n){
            if (currentWeight > maxW){
                maxW = currentWeight;
            }
            return;
        }
        if(mem[i][currentWeight]){
            return;
        }
        mem[i][currentWeight] = true;
        f(i+1, currentWeight);
        if (currentWeight + weight[i] <= w){
            f(i+1, currentWeight+weight[i]);
        }
    }

    public static void main(String[] args) {
        PackageProblem packageProblem = new PackageProblem();
        packageProblem.f(0,0);
    }
}
