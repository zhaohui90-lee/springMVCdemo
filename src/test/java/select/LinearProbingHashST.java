package select;

public class LinearProbingHashST<Key,Value> {
    private int n;          // 符号表中键值对的总数
    private int m = 16;     // 线性探测表的大小
    private Key[] keys;     // 键
    private Value[] vals;   // 值
    public LinearProbingHashST(){
        keys = (Key[]) new Object[this.m];
        vals = (Value[]) new Object[this.m];
    }
    public LinearProbingHashST(int capacity){
        keys = (Key[]) new Object[capacity];
        vals = (Value[]) new Object[capacity];
    }
    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % this.m;
    }
    private void resize(int cap){
        LinearProbingHashST<Key,Value> temp = new LinearProbingHashST<>(cap);

        for (int i = 0; i < this.m; i++) {
             if (keys[i] != null){
                 temp.put(keys[i],vals[i]);
             }
        }
        keys = temp.keys;
        vals = temp.vals;
        this.m = temp.m;
    }

    public void put(Key key, Value val) {
        if (this.n > this.m/2){
            // 将m加倍
            resize(this.m*2);
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1)/this.m) {
            if (keys[i].equals(key)){
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        this.n++;
    }

    public Value get(Key key){
        for (int i = hash(key); keys[i] != null; i = (i + 1)/this.m) {
            if (keys[i].equals(key)){
                return vals[i];
            }
        }
        return null;
    }
}
