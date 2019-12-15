package geektime.dynamic_41;

/**
 * @Author: sunguangchao
 * @Date: 2019/12/3 9:58 AM
 * 那从左上角移动到右下角的最短路径长度
 * min_dist(i, j) = w[i][j] + min(min_dist(i, j-1), min_dist(i-1, j))
 */
public class DistBT {
    private int minDist = Integer.MAX_VALUE;


    /**
     * 回溯算法
     * 遍历所有的路径
     * @param i
     * @param j
     * @param dist
     * @param w
     * @param n
     */
    public void minDistBT(int i, int j, int dist, int[][] w, int n) {
        if (i == n && j == n){
            if (dist < minDist){
                minDist = dist;
            }
            System.out.println("minDist=" + minDist);
            return;
        }

        if (i < n) {
            minDistBT(i + 1, j, dist + w[i][j], w, n);
        }
        if (j < n) {
            minDistBT(i, j + 1, dist + w[i][j], w, n);
        }
    }


    public int minDistDP(int[][] matrix, int n){
        int sum = 0;
        int[][] states = new int[n][n];
        //初始化第一行
        for (int j = 0; j < n; j++) {
            sum += matrix[0][j];
            states[0][j] = sum;
        }
        //初始化第一列
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][0];
            states[i][0] = sum;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                states[i][j] = matrix[i][j] +  Math.min(states[i][j-1], states[i-1][j]);
            }
        }
        return states[n-1][n-1];
    }


    public static void main(String[] args) {
        DistBT distBT = new DistBT();
        int[][] w = new int[4][4];
        w[0][0] = 1; w[0][1] = 3; w[0][2] = 5; w[0][3] = 9;
        w[1][0] = 2; w[1][1] = 1; w[1][2] = 3; w[1][3] = 4;
        w[2][0] = 5; w[2][1] = 2; w[2][2] = 6; w[2][3] = 4;
        w[3][0] = 6; w[3][1] = 8; w[3][2] = 4; w[3][3] = 3;
        distBT.minDistBT(0,0,0,w,3);
        System.out.println(distBT.minDistDP(w, 4));
    }
}
