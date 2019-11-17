package geektime.stack_08;


/**
 * @Author: sunguangchao
 * @Date: 2019/10/25 9:35 AM
 * 使用前后栈实现浏览器的前进和回退功能
 */
public class SimpleBrowser {




    private String currentPage;

    private LinkedListBaseStack backStack;

    private LinkedListBaseStack forwardStack;

    public SimpleBrowser(){
        backStack = new LinkedListBaseStack();
        forwardStack = new LinkedListBaseStack();
    }


    public void open(String url){
        if (this.currentPage != null){
            this.backStack.push(this.currentPage);
//            this.forwardStack.clear();
        }
        showUrl(url, "Open");
    }

    public String goBack(){
        if (this.canGoBack()){
            this.forwardStack.push(this.currentPage);
            String backUrl = (String) this.backStack.pop();
            showUrl(backUrl, "Back");
            return backUrl;
        }
        System.out.println("* Cannot go back, no pages behind");
        return null;
    }


    public String goForward(){
        if (this.canGoForward()){
            this.backStack.push(this.currentPage);
            String forwardUrl = (String) this.forwardStack.pop();
            showUrl(forwardUrl, "Forward");
            return forwardUrl;
        }
        System.out.println("** Cannot go forward, no pages ahead.");
        return null;

    }



    public void showUrl(String url, String prefix){
        this.currentPage = url;
        System.out.println(prefix + " page==" + url);
    }

    public void checkCurrentPage() {
        System.out.println("Current page is: " + this.currentPage);
    }

    public boolean canGoBack(){
        return this.backStack.size > 0;
    }

    public boolean canGoForward(){
        return this.forwardStack.size > 0;
    }

    public static class LinkedListBaseStack<T>{
        private int size;

        private Node top;

        private Node createNode(T data, Node next){
            return new Node(data, next);
        }

        public void clear(){
            this.top = null;
            size = 0;
        }

        /**
         * push的时候，将前一个的top节点，作为新加入节点的next结点
         * @param data
         */
        public void push(T data){
            Node newNode = createNode(data, this.top);
            this.top = newNode;
            this.size++;
        }


        public T pop(){
            Node popNode = this.top;
            if (popNode == null){
                System.out.println("stack is empty");
                return null;
            }
            this.top = popNode.next;
            if (this.size > 0){
                size--;
            }
            return (T)popNode.data;
        }

        public T getTopData(){
            if (this.top == null){
                return null;
            }
            return (T)this.top.data;
        }

        public int size(){
            return this.size;
        }


        public static class Node<T>{
            private T data;

            private Node next;


            public Node(T data){
                this(data, null);
            }

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

            @Override
            public String toString() {
                return "Node{" +
                        "data=" + data +
                        ", next=" + next +
                        '}';
            }
        }
    }


    public static void main(String[] args) {
        SimpleBrowser browser = new SimpleBrowser();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");
        browser.goBack();
        browser.goBack();
        browser.goForward();
        browser.open("http://www.qq.com");
        browser.goForward();
        browser.goBack();
        browser.goForward();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.checkCurrentPage();
    }
}
