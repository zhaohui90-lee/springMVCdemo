package sort;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class MergeBU {
    private static Comparable[] aux;
    public static void sort(Comparable[] a){
        // 进行lgN次两两归并
        int N = a.length;
        aux = new Comparable[N];
        // sz子数组大小
        for (int sz = 1; sz < N; sz=sz+sz) {
            // lo:子数组索引
            for (int lo = 0; lo < N-sz; lo+= sz+sz) {
                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
            }
        }
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
        sort(a); // time: 0.248 seconds time: 0.228 seconds time: 0.21 seconds time: 0.465 seconds time: 0.349 seconds
        double time = timer.elapsedTime();
        System.out.println("time: " + time + " seconds");
    }
}
