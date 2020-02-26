package sort;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 快速排序
 */
public class MyQuick {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        // 将数组切分为a[lo..i-1] a[i] a[i+a..hi]
        int i = lo,j = hi + 1; // 左右扫描指针
        Comparable v = a[lo];
        while (true){
            // 扫描左右，检查扫描是否结束并交换元素
            // a[i]小于v，索引右移，直到a[i]大于v，记录i
            while (less(a[++i],v)) if (i == hi) break;
            // a[j]大于v，索引左移，直到a[j]小于v，记录j
            while (less(v,a[--j])) if (j == lo) break;
            if (i >= j) break;
            // 根据之前记录的i,j,调换位置
            exch(a,i,j);
        }
        exch(a,lo,j); // 将v = a[j]放入正确的位置
        return j; // 将a[lo..j-1] <= a[j] <= a[j+1..hi]达成
    }
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Double[] a = new Double[100000];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform();
        }
        Stopwatch timer = new Stopwatch();
        sort(a); // time: 0.199 seconds time: 0.206 seconds time: 0.227 seconds time: 0.122 seconds time: 0.148 seconds
        double time = timer.elapsedTime();
        System.out.println("time: " + time + " seconds");
    }
}
