package geektime.array_05;

/**
 * @Author: sunguangchao
 * @Date: 2019/12/31 4:33 PM
 * 动态数组
 * 动态数组底层也是数组，区别在于添加的时候支持从中间插入，支持动态扩容
 * 移除的时候支持缩容
 */
public class GenericArray<T> {
    private T[] data;
    private int size;

    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public GenericArray() {
        this(10);
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取当前元素个数
     *
     * @return
     */
    public int count() {
        return size;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 修改 index 位置的元素
     *
     * @param index
     * @param e
     */
    public void set(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }

    /**
     * 获取对应 index 位置的元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取对应元素的下标, 未找到，返回 -1
     *
     * @param e
     * @return
     */
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 在index位置添加元素 important
     * 时间复杂度O(n)
     * @param index
     * @param e     index后面位置的元素后移一位
     *              如果当前元素个数等于数组容量，则将数组扩容为原来的两倍
     */
    public void add(int index, T e) {
        checkIndexForAdd(index);
        if (size == data.length) {
            resize(2 * data.length);
        }
        //后移一位
        for (int i = size - 1; i > index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }


    /**
     * 扩容方法
     * 时间复杂度O(n)
     * @param capacity
     */
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        //注意这里扩容为原来的两倍，数据只是到capacity / 2
        for (int i = 0; i < capacity / 2; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 缩容
     * @param capacity
     */
    private void resize2(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        //注意这里扩容为原来的两倍，数据只是到capacity / 2
        for (int i = 0; i < capacity; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // 向数组头插入元素
    public void addFirst(T e) {
        add(0, e);
    }

    // 向数组尾插入元素
    public void addLast(T e) {
        add(size, e);
    }


    /**
     * 删除index位置的元素，并返回
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        checkIndex(index);
        T ret = data[index];
        //前移一位
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        //注意，这里缩容的地方要除以4
        if (size == data.length / 2 && data.length / 2 != 0) {
            resize2(data.length / 2);
        }
        return ret;
    }

    // 删除第一个元素
    public T removeFirst() {
        return remove(0);
    }

    // 删除末尾元素
    public T removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除指定元素
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index < size.");
        }
    }

    /**
     * 添加元素前检查
     *
     * @param index
     */
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index <= size.");
        }
    }
}
