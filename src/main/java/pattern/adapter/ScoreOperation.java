package pattern.adapter;

/**
 * Created by 11981 on 2018/5/13.
 */
public interface ScoreOperation {
    int[] sort(int array[]);//成绩排序

    int search(int array[], int key);//成绩查找
}
