package geektime.linkedList_06;

import java.util.Scanner;

/**
 * @Author: sunguangchao
 * @Date: 2019/10/22 9:35 AM
 * 基于单链表实现LRU算法
 */
public class LRUBaseLinkedList<T> {

    /**
     * 默认链表容量
     */
    private static final Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private SNode<T> headNode;

    /**
     * 链表当前长度
     */
    private Integer length;


    /**
     * 链表容量
     */
    private Integer capacity;

    public LRUBaseLinkedList(){
        this.headNode = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity){
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data){
        //找到数据对应节点的前节点
        SNode preNode = findPreNode(data);
        //如果链表中已经存在，删除原数据，再插入到链表的头部
        if (preNode != null){
            deleteElemOptim(preNode);
            insertElemAtBegin(data);
        }else{
            if (length >= this.capacity){
                //删除尾结点
                deleteElemAtEnd();
            }
            insertElemAtBegin(data);
        }
    }




    /**
     * 删除preNode结点的下一个元素
     * @param preNode
     */
    private void deleteElemOptim(SNode preNode){
        SNode tmp = preNode.getNext();
        preNode.setNext(tmp.getNext());
        tmp = null;
        length--;
    }

    /**
     * 在链表头部插入结点
     * @param data
     */
    private void insertElemAtBegin(T data){
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data, next));
        length++;
    }

    /**
     * 获取查找到元素的前一个结点
     * @param data
     * @return
     */
    private SNode findPreNode(T data){
        SNode node = headNode;
        while (node.getNext() != null){
            if (data.equals(node.getNext().getElement())){
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * 删除最后一个结点
     */
    private void deleteElemAtEnd(){
        SNode ptr = headNode;
        //空链表直接返回
        if (ptr.getNext() == null){
            return;
        }
        //循环找到倒数第二个节点
        while (ptr.getNext().getNext() != null){
            ptr = ptr.getNext();
        }
        SNode tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length--;
    }

    private void printAll(){
        SNode node = headNode.getNext();
        while (node != null){
            System.out.println(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }


    public class SNode<T>{
        private T element;

        private SNode next;

        public SNode(T element){
            this.element = element;
        }

        public SNode(T element, SNode next){
            this.element = element;
            this.next = next;
        }

        public SNode(){
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }
}
