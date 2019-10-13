package pattern.adapter;

/**
 * Created by 11981 on 2018/5/13.
 * 快速排序
 */
public class QuickSort {
    public int[] quickSort(int array[]){
        sort(array, 0, array.length-1);
        return array;

    }
    public void sort(int array[], int lo, int hi){
        if (hi <= lo) return;
        int j = partition(array, lo, hi);
        sort(array, lo, j-1);
        sort(array, j+1, hi);

    }

    public int partition(int[] a, int lo, int hi){
        int i = lo;
        int j = hi + 1;//左右扫描的指针
        int v = a[lo];//切分元素
        while (true){
            while (a[++i] < v){
                if (i == hi) break;
            }
            while (v < a[--j]){
                if (j == lo) break;
            }
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j){
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
