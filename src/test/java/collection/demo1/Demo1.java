package collection.demo1;

/**
 * @Author: melody
 * @Date: 2020-05-11
 */
public class Demo1 {
    private String s;
    public Demo1(String s){
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}
