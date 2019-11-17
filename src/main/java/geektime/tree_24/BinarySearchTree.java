package geektime.tree_24;

/**
 * @Author: sunguangchao
 * @Date: 2019/11/5 8:50 PM
 * 二叉搜索树
 */
public class BinarySearchTree {
    private Node tree;


    /**
     * 根据值，找到对应的节点，时间复杂度是O(logn)
     *
     * @param data
     * @return
     */
    public Node find(int data) {
        if (tree == null) {
            return null;
        }
        Node p = tree;
        if (data < p.data) {
            p = p.left;
        } else if (data > p.data) {
            p = p.right;
        } else {
            return p;
        }
        return null;
    }


    public void delete(int data){
        Node p = tree;
        Node pp = null;
        while (p != null && p.data != data){
            pp = p;
            if (data > p.data){
                p = p.right;
            }else{
                p = p.left;
            }
        }
        //没有找到
        if (p == null){
            return;
        }
        //要删除的节点有两个子节点
        //查找右子树的最小节点
        if (p.left != null && p.right != null){
            Node minP = p.right;
            //minPP为minP的父节点
            Node minPP = p;
            //找到右子树的最小节点
            while (minP.left != null){
                minPP = minP;
                minP = minP.left;
            }
            //将minP的数据替换到p中
            p.data = minP.data;
            p = minP;
            pp = minPP;
        }
        //要删除的节点是叶子节点，或者是仅有一个子节点
        Node child;

        if (p.left != null){
            child = p.left;
        }else if (p.right != null){
            child = p.right;
        }else {
            child = null;
        }

        //如果是根节点
        if (pp == null){
            tree = child;
        }else if (pp.left == p){
            pp.left = child;
        }else{
            pp.right = child;
        }
    }

    /**
     * 插入结点
     *
     * @param data
     */
    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }





    /**
     * 找到值最小的节点
     * @return
     */
    public Node findMin(){
        if (tree == null){
            return null;
        }
        Node p = tree;
        while (p.left != null){
            p = p.left;
        }
        return p;
    }


    /**
     * 找到值最大的节点
     *
     * @return
     */
    public Node findMax() {
        if (tree == null) {
            return null;
        }
        Node p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }


    /**
     * 先序遍历，打印节点
     * @param root
     */
    public static void preOrder(Node root){
        if (root == null){
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
