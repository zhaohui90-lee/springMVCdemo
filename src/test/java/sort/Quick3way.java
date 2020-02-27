package sort;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.TopM;

public class Quick3way {

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int lo,int hi){
        if (hi <= lo) return;
        int lt = lo,i = lo + 1,gt = hi;
        Comparable v = a[lo];
        while (i <= gt){
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a,lt++,i++);
            else if (cmp > 0) exch(a,i,gt--);
            else i++;
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[1000];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(1000);
//            a[i] = 100.100; // time: 0.363 seconds time: 0.366 seconds time: 0.356 seconds
        }
        Stopwatch timer = new Stopwatch();
        sort(a); // time: 0.135 seconds time: 0.148 seconds time: 0.321 seconds time: 0.128 seconds time: 0.177 seconds
        double time = timer.elapsedTime();
//        for (Integer i : a) {
//            System.out.print(i + ",");
//        }
        System.out.println();
        int count = 0;
        // 0 1 1 1 2 2 3
        if (!a[a.length - 1].equals(a[a.length-2])){
            count++;
        }
        for (int i = 1; i < a.length - 1; i++) {
            if (!a[i].equals(a[i-1]) && !a[i].equals(a[i+1])){
                count ++;
            }
        }
        System.out.println("total: " + count);
        System.out.println("time: " + time + " seconds");
    }
}
