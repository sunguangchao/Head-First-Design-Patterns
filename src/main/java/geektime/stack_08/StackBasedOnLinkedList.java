package geektime.stack_08;

/**
 * Created by 11981 on 2019/11/24.
 * 基于链表实现栈
 */
public class StackBasedOnLinkedList {
    private Node top = null;


    public void push(int value){
        Node newNode = new Node(value, null);
        if (top == null){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
    }


    public int pop(){
        if (top == null){
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }


    public void printAll(){
        Node p = top;
        while (p != null){
            System.out.println("node value=" + p.data);
            p = p.next;
        }
        System.out.println();
    }


    private static class Node{
        private int data;
        private Node next;

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return data;
        }
    }
}
