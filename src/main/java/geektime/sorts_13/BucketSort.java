package geektime.sorts_13;

import java.util.Arrays;

/**
 * @Author: sunguangchao
 * @Date: 2019/10/30 12:55 PM
 */
public class BucketSort {
    /**
     * 桶排序
     * @param arr-原始数组
     * @param bucketSize-每个桶的大小
     */
    public static void bucketSort(int[] arr, int bucketSize){
        if (arr.length < 2){
            return;
        }
        int minValue = arr[0];
        int maxValue = arr[1];
        //找到数组中的最大值和最小值
        for (int i = 0; i <arr.length ; i++) {
            if (minValue > arr[i]){
                minValue = arr[i];
            }else if (maxValue < arr[i]){
                maxValue = arr[i];
            }
        }

        //桶的数量
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][bucketSize];
        int[] indexArr = new int[bucketCount];
        //将数组中的值分配到各个桶里
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (arr[i] - minValue) / bucketSize;
            if (indexArr[bucketIndex] == buckets[bucketIndex].length){
                ensureCapacity(buckets, bucketIndex);
            }
            buckets[bucketIndex][indexArr[bucketIndex]++] = arr[i];
            System.out.println("indexArr=" + indexArr[bucketIndex]);
        }
        //对每个桶进行排序，这里使用了快速排序

        int k = 0;

        for (int i = 0; i < buckets.length; i++) {
            if (indexArr[i] == 0){
                continue;
            }
            quickSort(buckets[i], 0, indexArr[i] - 1);
            for (int j = 0; j < indexArr[i]; j++){
                arr[k++] = buckets[i][j];
            }
        }

    }

    /**
     * 扩容
     * @param buckets
     * @param bucketIndex
     */
    private static void ensureCapacity(int[][] buckets, int bucketIndex){
        int[] tmpArr = buckets[bucketIndex];
        int[] newArr = new int[tmpArr.length * 2];
        for (int i = 0; i < tmpArr.length; i++) {
            newArr[i] = tmpArr[i];
        }
        buckets[bucketIndex] = newArr;
    }





    private static void quickSort(int[] arr, int p, int r){
        if (p >= r){
            return;
        }
        int q = partition(arr, p, r);
        quickSort(arr, p, q-1);
        quickSort(arr, q+1, r);
    }

    private static int partition(int[] arr, int p, int r){
        int pivot = arr[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (arr[j] <= pivot){
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    /**
     * 交换
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = {3,3,2,2,1,1,8,8,9,10};
        bucketSort(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
}
