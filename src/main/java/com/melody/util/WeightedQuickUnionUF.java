package com.melody.util;

/**
 * 加权quick-union
 */
public class WeightedQuickUnionUF {
    /**
     * 父链接数组（由触点索引）
     */
    private int[] id;
    /**
     * （由触点索引的）
     */
    private int[] sz;
    /**
     * 连通分量的数量
     */
    private int count;
    public WeightedQuickUnionUF(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = i;
        }
    }
    public int count(){
        return count;
    }
    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    private int find(int p) {
        // 跟随连接找到根节点
        while (p != id[p]){
            p = id[p];
        }
        return p;
    }
    public void union(int p,int q){
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }
        if (sz[i] < sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }
}
