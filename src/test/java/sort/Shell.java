package sort;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 希尔排序：
 * 使数组中任意间隔为h的元素都是有序的，这样的数组被称之为h有序数组；
 * 换句话说，一个h有序数组就是h个相互独立的有序数组编织在一起组成的一个
 * 数组；
 * 在进行排序时，如果h很大，我们就能将元素移动到很远的地方，为实现更小的
 * h有序创造方便；用这种方式，对于任意以1结尾的h序列，我们都能讲数组排序
 */
public class Shell {

    public static void sort(Comparable[] a){
        // 将a[]按升序排列
        int N = a.length;
        int h = 1;
        while (h < N/3){
            h = 3*h + 1;
        }
        while (h > 1){
            // 将数组变为有序
            for (int i = 0; i < N; i++) {
                // 将a[i]插入到a[i-h] a[1-2*h] ...之中
                for (int j = i; j >=h && less(a[j],a[j-h]); j-=h) {
                    exch(a,j,j-h);
                }
            }
            h = h/3;
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
        Double[] a = new Double[100000];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform()*100;
        }
        Stopwatch timer = new Stopwatch();
        sort(a); // time: 0.176 seconds time: 0.145 seconds
        double time = timer.elapsedTime();
        System.out.println("time: " + time + " seconds");
    }
}
