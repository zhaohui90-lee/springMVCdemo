package sort;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Select {
    public static void sort(Comparable[] a){
        // 将a[]按升序排列
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // 将a[i]和a[i+1..N]中最小的元素交换
            // 最小元素索引
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[j],a[min])){
                    min = j;
                }
            }
            exch(a,i,min);
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
