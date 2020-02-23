package collection;

import edu.princeton.cs.algs4.StdIn;

import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {
        Stack<Integer> stack;
        stack = new Stack<>();
        while (!StdIn.isEmpty()){
            stack.push(StdIn.readInt());
        }
        for (Integer i : stack) {
            System.out.println(i);
        }
    }
}
