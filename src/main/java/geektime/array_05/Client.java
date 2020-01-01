package geektime.array_05;

/**
 * @Author: sunguangchao
 * @Date: 2019/12/31 7:26 PM
 */
public class Client {
    public static void main(String[] args) {
        GenericArray array = new GenericArray(5);
        for (int i = 0; i < 100; i++) {
            array.add(i, i);
        }
        System.out.println(array.toString());
        for (int i = 99; i > 50; i--) {
            array.remove(i);
        }
        System.out.println(array.toString());
    }
}
