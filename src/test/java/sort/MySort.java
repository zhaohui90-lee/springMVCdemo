package sort;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdRandom;

public class MySort {
    public static void main(String[] args) {
        Double[] a = new Double[20];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform();
        }
        for (Double d : a) {
            System.out.print(d + ",");
        }
        Quick.sort(a);
        System.out.println();
        for (Double d : a) {
            System.out.print(d + ",");
        }
    }


}
