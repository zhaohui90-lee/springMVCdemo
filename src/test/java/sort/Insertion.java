package sort;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Insertion {
    public static void sort(Comparable[] a){
        // a[]按升序排列
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // 将a[i]插入到a[i-1] a[i-2]之中
            for (int j = i; j >0 && less(a[j],a[j-1]); j--) {
                exch(a,j,j-1);
            }
        }
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
        Integer[] a = new Integer[200];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(100);
        }
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        Stopwatch timer = new Stopwatch();
        sort(a);
        double time = timer.elapsedTime();
        System.out.println("time: " + time + "seconds");
        System.out.println();
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
