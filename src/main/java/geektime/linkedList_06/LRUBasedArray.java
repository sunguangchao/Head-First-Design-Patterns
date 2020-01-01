package geektime.linkedList_06;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 11981 on 2020/1/1.
 * * 基于数组实现的LRU缓存
 * 1. 空间复杂度为O(n)
 * 2. 时间复杂度为O(n)
 * 3. 不支持null的缓存
 */
public class LRUBasedArray<T> {
    private static final int DEFAULT_CAPACITY = (1 << 3);
    /**
     * 容量
     */
    private int capacity;

    /**
     * 容器中当前元素的个数
     */
    private int count;

    private T[] value;

    /**
     * 记录对象和在数组中对应的位置
     */
    private Map<T, Integer> holder;

    public LRUBasedArray(){
        this(DEFAULT_CAPACITY);
    }


    public LRUBasedArray(int capacity){
        this.capacity = capacity;
        value = (T[])new Object[capacity];
        count = 0;
        holder = new HashMap<T, Integer>(capacity);
    }


    /**
     * 模拟访问某个值
     * @param object
     */
    public void offer(T object){
        if (object == null){
            throw new IllegalArgumentException("该缓存容器不支持null!");
        }
        Integer index = holder.get(object);
        if (index == null){
            if (isFull()){
                removeAndCache(object);
            }else {
                cache(object, count);
            }
        }else {
            update(index);
        }
    }

    /**
     * 若缓存中有指定的值，则更新位置
     * @param end
     */
    public void update(int end){
        T target = value[end];
        rightShift(end);
        value[0] = target;
        holder.put(target, 0);
    }


    /**
     * 缓存数据到头部，但是要先右移
     * @param object
     * @param end
     */
    public void cache(T object, int end) {
        rightShift(end);
        value[0] = object;
        holder.put(object, 0);
        count++;
    }

    public void removeAndCache(T object){
        T key = value[--count];
        holder.remove(key);
        cache(object, count);
    }


    /**
     * end左边的数据统一右移一位
     * @param end
     */
    private void rightShift(int end){
        for (int i = end-1; i >= 0 ; i--) {
            value[i+1] = value[i];
            holder.put(value[i], i+1);
        }
    }

    public boolean isContain(T object){
        return holder.containsKey(object);
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == capacity;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LRUBasedArray<Integer> lruBasedArray = new LRUBasedArray();
        for (int i = 0; i < 10; i++) {
            lruBasedArray.offer(i);
        }
        System.out.println(lruBasedArray.toString());
        lruBasedArray.offer(8);
        System.out.println(lruBasedArray.toString());
        lruBasedArray.offer(100);
        System.out.println(lruBasedArray.toString());

    }
}
