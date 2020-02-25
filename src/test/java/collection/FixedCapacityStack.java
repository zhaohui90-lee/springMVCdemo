package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void push(Item item){
        if (N == a.length) resize(2*a.length);
        a[N++] = item;
    }

    private void resize(int max) {
        // 将大小为N<=max的栈移动到一个新的大小为max的数组中
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public Item pop(){
        // 从栈定删除元素
        Item item = a[--N];
        a[N] = null;// 避免对象游离
        if (N > 0 && N == a.length/4) resize(a.length/2);
        return item;
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> fixedCapacityStack = new FixedCapacityStack<>(10);
        fixedCapacityStack.push("a");
        System.out.println(fixedCapacityStack.pop());

//        Stack<String> strings = new Stack<>();
//        strings.push("sss");
//        System.out.println(strings.elementAt(0));
    }
}
