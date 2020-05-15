package myexception.demo1;

/**
 * @Author: melody
 * @Date: 2020-05-15
 */
public class FullConstructor {
    public static void f() throws MyException{
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException{
        System.out.println("Throwing MyException from g()");
        throw new MyException("Original in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        }catch (MyException e){
            e.printStackTrace(System.out);
        }
        try {
            g();
        }catch (MyException e){
            e.printStackTrace();
        }
    }
}
