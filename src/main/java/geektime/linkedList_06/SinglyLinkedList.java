package geektime.linkedList_06;


/**
 * @Author: sunguangchao
 * @Date: 2019/10/22 6:18 PM
 */
public class SinglyLinkedList<T> {
    private Node head = null;

    /**
     * 根据value查询对应的结点
     *
     * @param data
     * @return
     */
    public Node findByValue(T data) {
        Node p = head;
        while (p != null && !p.getData().equals(data)) {
            p = p.getNext();
        }
        return p;
    }

    public void insertToHead(T value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * 顺序插入，链表尾部插入
     *
     * @param value
     */
    public void insertTail(T value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
        } else {
            //顺序找到原来的最后一个结点
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }
            newNode.next = null;
            q.next = newNode;
        }
    }

    public void insertAfter(Node p, T value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    /**
     * 将newNode插入到p节点后面
     *
     * @param p
     * @param newNode
     */
    public void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
    }


    /**
     * 将newNode结点插入到p节点前面
     *
     * @param p
     * @param newNode
     */
    public void insertBefore(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        if (head == p) {
            insertToHead(newNode);
            return;
        }
        Node tmp = head;
        //找到p节点的前一个节点
        while (tmp != null && tmp.next != p) {
            tmp = tmp.next;
        }
        if (tmp == null) {
            return;
        }
        newNode.next = p;
        tmp.next = newNode;
    }

    /**
     * 删除节点p
     *
     * @param p
     */
    public void deleteByNode(Node p) {
        if (p == null || head == null) {
            return;
        }
        if (p == head) {
            head = head.next;
        }
        //找到p的前一个节点
        Node tmp = head;
        while (tmp != null && tmp.next != p) {
            tmp = tmp.next;
        }
        if (tmp == null) {
            return;
        }
        tmp.next = tmp.next.next;
    }


    public void deleteByValue(T value) {
        if (head == null) {
            return;
        }
        Node tmp = head;
        //q是去前一个节点
        Node q = null;
        while (tmp != null && tmp.data != value) {
            q = tmp;
            tmp = tmp.next;
        }
        if (tmp == null) {
            return;
        }
        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }
    }

    /**
     * 打印全部节点
     */
    private void printAll() {
        Node p = head;
        while (p != null) {
            System.out.println(p.data + "");
            p = p.next;
        }
        System.out.println();
    }


    /**
     * 比较两个节点开始的链表，是否一样
     *
     * @param left
     * @param right
     * @return
     */
    private boolean TFResult(Node left, Node right) {
        Node l = left;
        Node r = right;
        System.out.println("left_:" + l.data);
        System.out.println("right_:" + r.data);
        while (l != null && r != null) {
            if (l.data == r.data) {
                l = l.next;
                r = r.next;
                continue;
            } else {
                break;
            }
        }
        System.out.println("什么结果");
        if (l == null && r == null) {
            System.out.println("什么结果");
            return true;
        } else {
            return false;
        }
    }


    /**
     * 判断是否为回文
     *
     * @return
     */
    public boolean palindrome() {
        if (head == null) {
            return false;
        }

        System.out.println("开始执行找到中间节点");
        Node p = head;
        Node q = head;

        if (p.next == null) {
            System.out.println("只有一个结点");
            return true;
        }
        while (q.next != null && q.next.next != null) {
            q = q.next.next;
            p = p.next;
        }
        System.out.println("中间节点:" + p.toString());
        System.out.println("开始执行奇数节点的回文判断");
        Node leftLink = null;
        Node rightLink = null;
        //当是奇数个节点的时候，p所在的节点为中间节点,且q的next节点一定是空的
        if (q.next == null) {
            rightLink = p.next;
            leftLink = inverseLinkList(p).next;
            System.out.println("左边第一个节点" + leftLink.data);
            System.out.println("右边第一个节点" + rightLink.data);
        } else {
            rightLink = p.next;
            leftLink = inverseLinkList(p);
        }
        return TFResult(leftLink, rightLink);
    }


    /**
     * 无头结点的链表翻转
     *
     * @param p
     * @return
     */
    public Node inverseLinkList(Node p) {
        Node pre = null;
        Node r = head;
        Node next = null;
        //todo 这个地方是难点，不太好理解
        while (r != p) {
            next = r.next;
            r.next = pre;
            //跳转到下一个节点
            pre = r;
            r = next;
        }
        r.next = pre;
        //返回左半部分的中间之前的节点
        //此处开始同步向两边比较
        return r;
    }


    public static <T> Node createNode(T value) {
        return new Node(value, null);
    }

    /**
     * 内部类实现链表的节点
     *
     * @param <T>
     */
    public static class Node<T> {
        private T data;
        private Node next;

        public Node(T data, Node next) {
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

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        int data[] = {1, 2, 5, 5, 2, 1};
        for (int i = 0; i < data.length; i++) {
            linkedList.insertTail(data[i]);
        }
        System.out.println("打印原始:");
        linkedList.printAll();
        if (linkedList.palindrome()) {
            System.out.println("回文");
        } else {
            System.out.println("不是回文");
        }
    }
}
