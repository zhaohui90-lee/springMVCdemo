package collection.demo7;

/**
 * @Author: melody
 * @Date: 2020-05-14
 */
public abstract class Test<C> {
    String name;
    public Test(String name){
        this.name = name;
    }
    abstract int test(C container,TestParam tp);
}
