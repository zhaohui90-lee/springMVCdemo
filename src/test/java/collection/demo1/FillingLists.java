package collection.demo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: melody
 * @Date: 2020-05-11
 */
public class FillingLists {
    public static void main(String[] args) {
        List<Demo1> list = new ArrayList<>(
                Collections.nCopies(4,new Demo1("Hello"))
        );
        System.out.println(list);
        Collections.fill(list,new Demo1("World!"));
        System.out.println(list);
    }
}
