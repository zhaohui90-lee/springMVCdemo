package sort;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 归并排序
 * 自顶向下的归并排序
 * 时间复杂度---O（NlgN）
 */
public class Merge {
    private static Comparable[] aux;
    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        // 将数组a[lo..hi]排序
        if (hi <= lo) return;
        int mid = lo + (hi -lo)/2;
        // 将左半边排序
        sort(a,lo,mid);
        // 将右半边排序
        sort(a,mid+1,hi);
        // 归并结果
        merge(a,lo,mid,hi);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        // 将a[lo..mid] 和 a[mid+1..hi]归并
        int i = lo,j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if (less(aux[j],aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        Double[] a = new Double[100000];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform();
        }
        Stopwatch timer = new Stopwatch();
        sort(a); // time: 0.132 seconds
        double time = timer.elapsedTime();
        System.out.println("time: " + time + " seconds");
    }
}
