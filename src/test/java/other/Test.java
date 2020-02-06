package other;

import java.util.Random;

public class Test {

    static int i = 47;

    static int storage(String s){
        return s.length() * 2;
    }

    public static void main1(String[] args) {
        System.out.println(storage("还在"));
        Test t1 = new Test();
        System.out.println(t1.i);
        Test t2 = new Test();
        System.out.println(t2.i);

        System.out.println(Test.i++);

        System.out.println(Test.i);
    }

    public static void main2(String[] args) {
        int i = -1;
        System.out.println(Integer.toBinaryString(i));

        i >>>=10;

        System.out.println(Integer.toBinaryString(i));

        long l = -1L;

        System.out.println(l);

        l >>>=10;

        System.out.println(l);

        short s = -1;

        System.out.println(Integer.toBinaryString(s));

        s >>>= 10;

        System.out.println(Integer.toBinaryString(s));

        byte b = -1;
        System.out.println(Integer.toBinaryString(b));

        b>>>=10;
        System.out.println(Integer.toBinaryString(b));
    }

    public static void main3(String[] args) {
        Random rand = new Random(47);
        int i = rand.nextInt();
        int j = rand.nextInt();
        printBinaryInt("-1",-1);
        printBinaryInt("+1",+1);
        int maxpos = Integer.MAX_VALUE;
        printBinaryInt("maxpos",maxpos);
        int minpos = Integer.MIN_VALUE;
        printBinaryInt("minpos",minpos);

        printBinaryInt("~i",~i);
        printBinaryInt("-i",-i);
        printBinaryInt("i",i);
        printBinaryInt("j",j);

        printBinaryInt("i & j",i & j);//全部相同则为1，不同则为0
        printBinaryInt("i | j",i | j);//全部为0则为0，全部为1则为1，不同则为1
        printBinaryInt("i ^ j",i ^ j);//全部相同则为0，不同则为1

        printBinaryInt("i << 5",i << 5);


    }

    public static void main4(String[] args) {
        int i = 10;
        long lng = (long)i;

        long l = 100L;
        int ii = (int) l;
    }

    public static void main(String[] args) {
//        System.out.println(isSushu(3));
//        printSuShu(10000);

        System.out.println("ubcuiywgycebc".toCharArray());
        for (char c : "ubcuiywgycebc".toCharArray()) {
            System.out.print(c + " ");
        }
    }

    static boolean isSushu(int number){
        // 判断是否小于等于1
        if (number <= 1){
            return false;
        }
        int j;
        for (j = 2; j < number; j++) {
            if(number%j == 0){
                return false;
            }
        }
        return true;
    }

    static void printSuShu(int range){
        // 判断是否小于等于1
        if (range <= 1){
            System.out.println("输入异常值...");
        }
        for (int j = 2; j <= range; j++) {
            for (int k = 2; k <= j; k++) {
                if (j%k == 0){
                    if(k != j){
                        break;
                    }else {
                        System.out.println("素数---> " + j);
                    }
                }
            }
        }
        System.out.println("素数检测完毕...");
    }

    static void printBinaryInt(String s,int i ){
        System.out.println(s + ",int:" + i + ",binary:\n " + Integer.toBinaryString(i));
    }

    static void printBinaryLong(String s,long l ){
        System.out.println(s + ",long:" + l + ",binary:\n " + Long.toBinaryString(l));
    }
}
