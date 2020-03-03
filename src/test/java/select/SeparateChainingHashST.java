package select;

import edu.princeton.cs.algs4.Queue;

import java.util.Iterator;

public class SeparateChainingHashST<Key,Value> {
    private int N;      //  键值总对数
    private int M;      //  散列表的大小
    private SequentialSearchST<Key,Value>[] st; // 存放链表对象的数组

    public SeparateChainingHashST(){
        this(997);
    }
    public SeparateChainingHashST(int M){
        // 创建M条链表
        this.M = M;
        st = new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }
    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public Value get(Key key){
        return st[hash(key)].get(key);
    }
    public void put(Key key,Value val){
        st[hash(key)].put(key,val);
    }
    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<>();

        for (int i = 0; i < this.M; i++) {
            Iterator var3 = this.st[i].keys().iterator();

            while (var3.hasNext()){
                Key key = (Key) var3.next();
                queue.enqueue(key);
            }
        }

        return queue;
    }
}
