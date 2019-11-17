package geektime.heap_28;

/**
 * @Author: sunguangchao
 * @Date: 2019/11/7 9:14 PM
 */
public class Heap {
    /**
     * 数组，从下标i开始存储数据
     */
    private int[] a;

    /**
     * 堆可以存储的最大数据个数
     */
    private int n;

    /**
     * 堆中已经存储的数据个数
     */
    private int count;


    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }


    /**
     * 插入一个节点，从下往上堆化
     * @param data
     */
    public void insert(int data){
        //堆满了
        if (count >= n){
            return;
        }
        int i = count;
        while (i/2 > 0 && a[i] > a[i/2]){
            swap(a, i, i/2);
            i = i/2;
        }
    }

    public static void swap(int[] arr, int i, int j){
        if (i == j){
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }



    
}
