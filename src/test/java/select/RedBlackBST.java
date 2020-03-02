package select;

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
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    public int size(){
        return this.size(root);
    }
    private int size(Node x){
        if (x == null) return 0;
        else return x.N;
    }
}
