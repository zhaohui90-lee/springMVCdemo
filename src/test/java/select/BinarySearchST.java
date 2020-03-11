package select;

import edu.princeton.cs.algs4.Queue;

import java.util.Objects;

public class BinarySearchST<Key extends Comparable<Key>,Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;
    public BinarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Objects[capacity];
    }
    public int size(){
        return this.N;
    }
    public Value get(Key key){
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < this.N && keys[i].compareTo(key) == 0) return vals[i];
        else return null;
    }

    /**
     * 二分法查找
     * @param key 查找的key
     * @return 返回查找的key索引
     */
    private int rank(Key key) {
        int lo = 0,hi = this.N - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) hi = mid + 1;
            else return mid;
        }
        return lo;
    }

    public void put(Key key,Value val){
        // 查找键，找到则更新；没找到则新增
        int i = rank(key);
        if (i < this.N && keys[i].compareTo(key) == 0){
            vals[i] = val;
            return;
        }
        for (int j = this.N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }
    //       4
    // 1 2 3 4 5 6
    // 1 2 3 5 6
    public void delete(Key key){
        if (key == null){
            throw new RuntimeException("argument to delete() is null");
        }else if (!this.isEmpty()){
            int i = this.rank(key);
            if (i != this.N && this.keys[i].compareTo(key) == 0){
                for (int j = i; j < this.N - 1; j++) {
                    this.keys[j] = this.keys[j + 1];
                    this.vals[j] = this.vals[j + 1];
                }
                this.N--;
                // 最候一位元素至为null，防止元素游离
                this.keys[this.N] = null;
                this.vals[this.N] = null;
                // 如果元素长度小于数组长度的1/4，则减半数组
                if (this.N > 0 && this.N == this.keys.length/4){
                    this.resize(this.keys.length/2);
                }
            }

        }
    }

    private void resize(int capacity) {
        assert capacity >= this.N;

        Key[] tempk = (Key[]) new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];

        for (int i = 0; i < capacity; i++) {
            tempk[i] = this.keys[i];
            tempv[i] = this.vals[i];
        }
        this.vals = tempv;
        this.keys = tempk;
    }

    private boolean isEmpty() {
        return this.size() == 0;
    }

    public Iterable<Key> keys(Key lo,Key hi){
        Queue<Key> queue = new Queue<>();
        for (int i = rank(lo); i < rank(hi); i++) {
            queue.enqueue(keys[i]);
        }
        if (contains(hi)){
            queue.enqueue(keys[rank(hi)]);
        }
        return queue;
    }

    private boolean contains(Key key) {
        if (key == null){
            throw new RuntimeException("argument to contains() is null");
        }
        return this.get(key) != null;
    }

    public Key min(){
        return keys[0];
    }

    public Key max(){
        return keys[this.N - 1];
    }

    public Key select(int k ){
        return keys[k];
    }

    public Key ceiling(Key key){
        int i = rank(key);
        return keys[i];
    }

    public Key floor(Key key){
        if (key == null){
            throw new IllegalArgumentException("argument to floor() is null");
        }else {
            int i = rank(key);
            if (i < this.N && key.compareTo(keys[i]) == 0){
                return this.keys[i];
            }else {
                return i == 0? null : keys[i - 1];
            }
        }
    }
}
