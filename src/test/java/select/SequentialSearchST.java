package select;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * 在长度为N的链表中插入N个元素，时间复杂度为O（N^2/2）
 * @param <Key>
 * @param <Value>
 */
public class SequentialSearchST<Key,Value>{
    private Node first;
    private int N;
    private class Node{
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key){
        for (Node x = first; x!=null ; x = x.next) {
            if (key.equals(x.key)){
                return x.val;
            }
        }
        return null;
    }

    public void put(Key key,Value val){
        for (Node x = first; x != null ; x = x.next) {
            if (key.equals(x.key)){
                x.val = val; // 命中，更新
                return;
            }
        }
        first = new Node(key,val,first); // 未命中，新建节点
    }

    public void delete(Key key){
        if (key == null){
            throw new IllegalArgumentException("argument to delete() is null");
        }else {
            this.first = this.delete(this.first,key);
        }
    }

    private Node delete(Node x, Key key) {
        if (x == null){
            return null;
        }else if (key.equals(x.key)){
            --this.N;
            return x.next;
        }else {
            x.next = this.delete(x.next,key);
            return x;
        }
    }

    public boolean contains(Key key){
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }
    public int size(){
        return this.N;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (Node x = first; x != null; x = x.next) {
            queue.dequeue();
        }
        return queue;
    }
}
