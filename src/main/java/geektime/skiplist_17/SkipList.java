package geektime.skiplist_17;

/**
 * @Author: sunguangchao
 * @Date: 2019/10/31 10:42 AM
 * 实现跳表
 * redis的有序集合使用
 */
public class SkipList {
    private static final float SKIPLIST_P = 0.5f;
    private static final int MAX_VALUE = 16;

    private int levelCount = 1;
    /**
     * 带头链表
     */
    private Node head = new Node();

    public Node find(int value) {
        Node p = head;
        //从最上面的层级开始遍历，
        for (int i = levelCount - 1; i >= 0; --i) {
            //如果data比value小，继续往后面的遍历
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }
        if (p.forwards[0] != null && p.forwards[0].data == value){
            return p.forwards[0];
        }else{
            return null;
        }
    }

    /**
     * 插入结点
     * @param value
     */
    public void insert(int value){
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        Node[] update = new Node[level];
        for (int i = 0; i < level; i++) {
            update[i] = head;
        }
        //通过update数组记录每个层级小于 value的最大的节点
        Node p = head;
        for (int i = level-1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value){
                p = p.forwards[i];
            }
            update[i] = p;
        }

        // in search path node next node become new node forwords(next)
        /**
         * 这里的插入跟单链表类似，只不过是有多个层级
         */
        for (int i = 0; i < level; i++) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }
        if (levelCount < level){
            levelCount = level;
        }
    }


    public void delete(int value){
        Node p = head;
        Node[] update = new Node[levelCount];
        for (int i = levelCount-1; i < 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value){
                p = p.forwards[i];
            }
            update[i] = p;
        }

        if (p.forwards[0] != null && p.forwards[0].data == value){
            for (int i= levelCount-1; i >=0; --i){
                update[i].forwards[i] = update[i].forwards[i].forwards[i];
            }
        }

        while (levelCount > 1 && head.forwards[levelCount] == null){
            levelCount--;
        }
    }






    // 理论来讲，一级索引中元素个数应该占原始数据的 50%，二级索引中元素个数占 25%，三级索引12.5% ，一直到最顶层。
    // 因为这里每一层的晋升概率是 50%。对于每一个新插入的节点，都需要调用 randomLevel 生成一个合理的层数。
    // 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
    //        50%的概率返回 1
    //        25%的概率返回 2
    //      12.5%的概率返回 3 ...


    private int randomLevel(){
        int level = 1;
        while (Math.random() < SKIPLIST_P && level < MAX_VALUE){
            level += 1;
        }
        return level;
    }


    public void printAll(){
        Node p = head;
        while (p.forwards[0] != null){
            System.out.println(p.forwards[0] + "");
            p = p.forwards[0];
        }
        System.out.println();
    }


    public class Node {
        private int data = -1;
        /**
         * 下一个数组节点
         * 最大是MAX_VALUE
         */
        private Node[] forwards = new Node[MAX_VALUE];
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }
}
