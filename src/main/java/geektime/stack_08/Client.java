package geektime.stack_08;

/**
 * Created by 11981 on 2020/1/1.
 */
public class Client {
    public static void main(String[] args) {
        StackBasedOnLinkedList stack = new StackBasedOnLinkedList();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        stack.printAll();
        System.out.println(stack.pop());
        stack.printAll();
    }
}
