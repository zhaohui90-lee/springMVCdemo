package select;

import java.util.NoSuchElementException;

public class RedBlackBST<Key extends Comparable<Key>,Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private class Node{
        Key key;            // 键
        Value val;          // 相关联的值
        Node left,right;    // 左右子树
        int N;              // 这棵子树中的结点总数
        boolean color;      // 由其父节点指向它的链接的颜色

        Node(Key key,Value val,int N,boolean color){
            this.key = key;
            this.val = val;
            this.color = color;
            this.N = N;
        }
    }

    public void put(Key key,Value val){
        // 查找key，找到则更新其值，否则为它新建一个结点
        root = put(root,key,val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null) return new Node(key,val,1,RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left,key,val);
        else if (cmp > 0) h.right = put(h.right,key,val);
        else h.val = val;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = 1 + size(h.left) + size(h.right);
        return h;
    }

    public void delete(Key key){
        if (key == null){
            throw new IllegalArgumentException("argument to delete() is null");
        }else if (this.contains(key)){
            if (!this.isRed(this.root.left) && !this.isRed(this.root.right)){
                this.root.color = RED;
            }

            this.root = this.delete(this.root,key);
            if (!this.isEmpty()){
                this.root.color = BLACK;
            }
        }

    }

    private Node delete(Node h, Key key) {
        if (key.compareTo(h.key) < 0){
            if (!this.isRed(h.left) && !this.isRed(h.right)){
                h = this.moveRedLeft(h);
            }

            h.left = this.delete(h.left,key);
        }else {
            if (this.isRed(h.left)){
                h = this.rotateRight(h);
            }
            if (key.compareTo(h.key) == 0 && h.right == null){
                return null;
            }
            if (!this.isRed(h.right) && !this.isRed(h.right.left)){
                h = this.moveRedRight(h);
            }
            if (key.compareTo(h.key) == 0){
                Node x = this.min(h.right);
                h.key = x.key;
                h.val = x.val;
                h.right = this.deleteMin(h.right);
            }else {
                h.right = this.delete(h.right,key);
            }
        }
        return this.balance(h);
    }

    private Node min(Node h) {
        return h.left == null ? h : this.min(h.left);
    }

    public void deleteMin(){
        if (this.isEmpty()){
            throw new NoSuchElementException("BST underflow");
        }else {
            if (!this.isRed(this.root.left) && !this.isRed(this.root.right)){
                this.root.color = RED;
            }

            this.root = this.deleteMin(this.root);
            if (!this.isEmpty()){
                this.root.color = BLACK;
            }
        }
    }

    private Node deleteMin(Node h) {
        if (h == null) {
            return null;
        }else {
            if (!this.isRed(h.left) && !this.isRed(h.right)){
                h = this.moveRedLeft(h);
            }

            h.left = this.deleteMin(h.left);
            return this.balance(h);
        }
    }

    public void deleteMax(){
        if (this.isEmpty()){
            throw new NoSuchElementException("BST underflow");
        }else {
            if (!this.isRed(this.root.left) && !this.isRed(this.root.right)){
                this.root.color = RED;
            }

            this.root = this.deleteMax(this.root);
            if (!this.isEmpty()){
                this.root.color = BLACK;
            }
        }
    }

    private Node deleteMax(Node h) {
        if (this.isRed(h.left)){
            h = this.rotateLeft(h);
        }

        if (h.right == null){
            return null;
        }else {
            if (!this.isRed(this.root.left) && !this.isRed(this.root.right)){
                h = this.moveRedRight(h);
            }

            h.right = this.deleteMax(h.right);
            return this.balance(h);
        }

    }

    private Node moveRedRight(Node h) {
        this.flipColors(h);
        if (this.isRed(h.left.left)){
            h = this.rotateRight(h);
            this.flipColors(h);
        }
        return h;
    }

    private Node balance(Node h) {
        if (this.isRed(h.right)){
            h = this.rotateLeft(h);
        }
        if (this.isRed(h.left) && this.isRed(h.right)){
            this.flipColors(h);
        }
        if (this.isRed(h.left) && this.isRed(h.left.left)){
            h = this.rotateRight(h);
        }

        h.N = 1 + size(h.left) + size(h.right);
        return h;
    }

    private Node moveRedLeft(Node h) {
        this.flipColors(h);
        if (this.isRed(h.right.left)){
            h.right = this.rotateRight(h);
            h = this.rotateLeft(h);
            this.flipColors(h);
        }
        return h;
    }

    private boolean isRed(Node x){
        if (x == null) return false;
        return x.color == RED;
    }

    Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(x.right);
        return x;
    }

    Node rotateRight(Node h){
        Node x = h.left;
        x.left = h.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    /**
     * 父节点为RED,其子节点都为BLACK
     * @param h 要改变颜色的结点
     */
    void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public int size(){
        return this.size(root);
    }
    private int size(Node x){
        if (x == null) return 0;
        else return x.N;
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public boolean contains(Key key){
        return this.get(key) != null;
    }

    private Value get(Key key) {
        if (key == null){
            throw new IllegalArgumentException("argument to get() is null");
        }else {
            return this.get(this.root,key);
        }
    }

    private Value get(Node x, Key key) {
        while (true){
            if (x != null){
                int cmp = key.compareTo(x.key);
                if (cmp < 0){
                    x = x.left;
                    continue;
                }

                if (cmp > 0){
                    x = x.right;
                    continue;
                }

                return x.val;
            }

            return null;
        }
    }

    public static void main(String[] args) {
    }
}
