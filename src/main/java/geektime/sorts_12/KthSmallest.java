package geektime.sorts_12;

import java.util.Arrays;

/**
 * @Author: sunguangchao
 * @Date: 2019/10/28 9:47 AM
 * 查找到乱序的数组中，第k大的元素，时间复杂度要求是O(n)
 */
public class KthSmallest {
    public static int kthSmallest(int[] arr, int k){
        if (arr == null || arr.length == 0){
            return -1;
        }
        int partition = partitions(arr, 0, arr.length-1);
        while (partition + 1 != k){
            if (partition + 1 < k){
                partition = partitions(arr, partition + 1, arr.length-1);
            }else{
                partition = partitions(arr, 0, partition-1);
            }
        }

        return arr[partition];

    }

    /**
     * 主要目的是选取最后一个值为分区点，
     * 返回这个值在数组中如果正常排序的位置
     * @param arr
     * @param p
     * @param r
     * @return
     */
    public static int partition(int[] arr, int p, int r){
        int pivot = arr[r];
        int i= p;
        for (int j = p; j < r; j++) {
            if (arr[j] <= pivot){
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    public static void swap(int[] arr, int i, int j){
        if (i == j){
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,6,9,8,5};
        System.out.println(kthSmallest(arr, 3));;
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 自己实现一遍
     * @param arr
     * @param m
     * @param n
     * @return
     */
    public static int partitions(int[] arr, int m, int n){
        int pivot = arr[n];
        int i = m;
        for (int j = m; j < n; j++){
            if (arr[j] < pivot){
                swap(arr, i , j);
                i++;
            }
        }
        swap(arr, i, n);
        return i;
    }
}
