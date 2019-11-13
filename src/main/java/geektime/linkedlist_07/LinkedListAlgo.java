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

    /**
     * 单链表反转
     * @param head
     * @return
     */
    public static Node reverseBy(Node head){
        Node curr = head, pre = null;
        while (curr != null){
            Node next = curr.next;
            curr.next = pre;
            //集体后移一位
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * 检测环
     * @param list
     * @return
     */
    public static boolean checkCircle(Node list){
        if (list == null){
            return false;
        }
        Node fast = list.next;
        Node slow = list;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                return true;
            }
        }
        return false;

    }

    /**
     * 合并两个有序链表，从小到大
     * @param l1
     * @param l2
     * @return
     */
    public Node mergeTwoList(Node l1, Node l2){
        Node head = new Node(0, null);
        Node p = head;
        while (l1 != null && l2 != null){
            if (l1.data < l2.data){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null){
            p.next = l1;
        }
        if (l2 != null){
            p.next = l2;
        }
        return head.next;
    }



    public static class Node{
        private Integer data;
        private Node next;

        public Node(Integer data, Node next){
            this.data = data;
            this.next = next;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
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
