package geektime.linkedlist_07;

/**
 * Created by 11981 on 2019/10/22.
 */
public class LinkedListAlgo {


    public static Node reverse(Node list){
        Node curr = list, pre = null;
        while (curr != null){
            Node next = curr.getNext();
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }




    public static class Node<T>{
        private T data;
        private Node next;

        public Node(T data, Node next){
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
