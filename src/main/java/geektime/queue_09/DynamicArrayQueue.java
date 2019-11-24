package geektime.queue_09;

/**
 * Created by 11981 on 2019/11/24.
 */
public class DynamicArrayQueue {
    private String[] items;
    /**
     * 数组大小
     */
    private int n = 0;
    /**
     * 队首下标
     */
    private int head;
    /**
     * 队尾下标
     */
    private int tail;


    /**
     * 入队操作
     * 动态扩容
     * @return
     */
    private boolean enqueue(String item){
        //队尾没有空间了
        if (tail == n){
            if (head == 0){
                return false;
            }
            for (int i = head; i < tail; ++i) {
                items[i-head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        tail++;
        return true;
    }


    /**
     * 出队
     * @return
     */
    private String dequeue(){
        if (head == tail){
            return null;
        }
        String ret = items[head];
        ++head;
        return ret;

    }
}
