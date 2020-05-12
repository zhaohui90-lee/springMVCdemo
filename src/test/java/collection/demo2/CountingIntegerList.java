package collection.demo2;

import java.util.AbstractList;

/**
 * @Author: melody
 * @Date: 2020-05-12
 */
public class CountingIntegerList extends AbstractList<Integer> {

    private int size;
    public CountingIntegerList(int size){
        this.size = Math.max(size, 0);
    }
    @Override
    public Integer get(int index) {
        return Integer.valueOf(index);
    }

    @Override
    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        System.out.println(new CountingIntegerList(30));
    }
}
