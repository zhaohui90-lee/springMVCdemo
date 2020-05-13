package collection.demo5;

/**
 * @Author: melody
 * @Date: 2020-05-13
 */
public class MyHash {
    public static void main(String[] args) {
        System.out.println("x".hashCode());

        // 00000001
        // 00000010
        // ---> 00000011
        System.out.println(1^2);

        System.out.println(1<<30);
    }
}
