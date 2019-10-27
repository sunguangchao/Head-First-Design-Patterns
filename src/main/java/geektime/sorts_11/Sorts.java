package geektime.sorts_11;

import java.util.Arrays;

/**
 * Created by 11981 on 2019/10/27.
 */
public class Sorts {
    /**
     *冒泡排序
     * @param a
     * @param n
     */
    public static void bubbleSort(int[] a, int n){
        if (n <= 1){
            return;
        }
        for (int i = 0; i < n; i++) {
            //提前退出标志位
            boolean flag = false;
            for (int j = 0; j < n-i-1; j++) {
                if (a[j] > a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;
                }
            }
            //没有数据交换，提前退出
            if (!flag){
                break;
            }
        }
    }

    /**
     * 插入排序
     * 分为有序到的和无序的两组，将无序的每个插入到有序数组的适当位置
     * 稳定的排序算法，
     * @param a
     * @param n
     */
    public static void insertionSort(int[] a,int n){
        if (n <= 1){
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i-1;
            for (; j >=0; j--) {
                if (a[j] > value){
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            //这里为什么是j--呢，因为跳出内层循环之前会走一个j--
            System.out.println(j);
            a[j+1] = value;
        }

    }

    /**
     * 选择排序，不是稳定的排序算法
     * @param a
     * @param n
     */
    public static void selectionSort(int[] a, int n){
        if (n <= 1){
            return;
        }
        for (int i = 0; i < n-1; i++) {
            int minValue = i;
            for (int j = i+1; j < n; j++) {
                if (a[j] < a[minValue]){
                    minValue = j;
                }
            }
            int tmp = a[i];
            a[i] = a[minValue];
            a[minValue] = tmp;
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        selectionSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
