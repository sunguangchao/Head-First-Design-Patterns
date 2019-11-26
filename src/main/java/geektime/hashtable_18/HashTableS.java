package geektime.hashtable_18;

import java.util.Map;

/**
 * Created by 11981 on 2019/11/24.
 */
public class HashTableS<K,V> {
    private static final int DEFAULT_INITAL_CAPACITY = 8;

    private static final float LOAD_FACTOR = 0.75f;

    private Entry<K,V>[] table;

    /**
     * 实际元素数量
     */
    private int size;

    /**
     * 散列表索引数量
     */
    private int use = 0;




    static class Entry<K,V>{
        K key;
        V value;
        Entry<K,V> next;

        Entry(K key, V value, Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
