package geektime.backtrack_39;

/**
 * @Author: sunguangchao
 * @Date: 2019/11/26 9:14 PM
 * 回溯算法
 * 8皇后问题
 * 我们有一个 8x8 的棋盘，希望往里放 8 个棋子（皇后），每个棋子所在的行、列、对角线都不能有另一个棋子。
 */
public class Cal8Queens {

    /**
     * 全局或成员变量,下标表示行,值表示queen存储在哪一列
     */
    int[] result = new int[8];

    public void cal8Queens(int row) {
        if (row == 8) {
            printQueens(result);
            return;
        }
        //每一行中都有8中放法
        for (int column = 0; column < 8; ++column) {
            if (isOk(row, column)) {
                result[row] = column;
                cal8Queens(row + 1);
            }
        }
    }

    /**
     * 检查从这这一行网上开始，对角线和向上的直线有没有在一条直线的
     * 判断row行column列放置是否合适
     * @param row    行，
     * @param column 列
     * @return
     */
    private boolean isOk(int row, int column) {
        int leftUp = column - 1;
        int rightUp = column + 1;
        //逐行往上考察每一行
        for (int i = row - 1; i >= 0; --i) {
            //第i行的column列有棋子吗？
            if (result[i] == column) {
                return false;
            }
            //考察左上对角线：第i行leftup列有棋子吗？
            if (leftUp >= 0) {
                if (result[i] == leftUp) {
                    return false;
                }
            }
            //考察右上对角线：第i行rightup列有棋子吗？
            if (rightUp < 8) {
                if (result[i] == rightUp) {
                    return false;
                }
            }
            --leftUp;
            ++rightUp;
        }
        return true;
    }


    /**
     * 打印一个二维矩阵
     *
     * @param result
     */
    private void printQueens(int[] result) {
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    public static void main(String[] args) {
        Cal8Queens cal8Queens = new Cal8Queens();
        cal8Queens.cal8Queens(0);
    }

}
