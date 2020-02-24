package collection;

import com.melody.util.BinarySearch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class MyStopwatch {
    public static void main(String[] args) {
        int N = Integer.parseInt("1000000");
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-1000000,1000000);
        }
        Stopwatch timer = new Stopwatch();
//        int cnt = MyStopwatch.ThreeSum.count(a);
//        ThreeSum ts = new MyStopwatch().new ThreeSum();
//        int cnt = ts.count(a);
        int cnt = MyStopwatch.TwoSum.count(a); // 50000 681 triple 2.358 seconds  N^2 1000000 943.2 seconds
//        int cnt = MyStopwatch.TwoSumFast.count(a); // 50000 605 triple 0.05 seconds NlgN 1000000 197073 triple 0.479 seconds
        double time = timer.elapsedTime();
        StdOut.println(cnt + " triple " + time + " seconds");
    }

    private static class ThreeSum{
        public static int count(int[] a){
            int N = a.length;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    for (int k = j+1; k < N; k++) {
                        if (a[i]+a[j]+a[k] == 0){
                            cnt++;
                        }
                    }
                }
            }
            return cnt;
        }
    }

    private static class TwoSum{
        public static int count(int[] a){
            int N = a.length;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    if (a[i]+a[j] == 0){
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }

    private static class TwoSumFast{
        public static int count(int[] a){
            Arrays.sort(a);
            int N = a.length;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (BinarySearch.rank(-a[i],a)>i){
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
