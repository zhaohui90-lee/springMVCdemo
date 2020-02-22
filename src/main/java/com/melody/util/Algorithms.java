package com.melody.util;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Algorithms {
    // 判断一个数是否为素数
    public static boolean isPrime(int N){
        if (N < 2) {
            return false;
        }
        for (int i = 2; i*i < N; i++) {
            if (N % i == 0){
                return false;
            }
        }
        return true;
    }

    // 计算平方根(牛顿迭代法)
    public static double sqrt(double c){
        if (c < 0){
            return Double.NaN;
        }
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c/t) > err * t){
            t = (c/t + t) /2.0;
        }
        return t;
    }

    // 计算直角三角形的斜边
    public static double hypotenuse(double a,double b){
        return Math.sqrt(a*a + b*b);
    }

    // 二分法查找
    public static int rank(int key,int[] a){
        return rank(key,a,0,a.length-1);
    }

    private static int rank(int key, int[] a, int lo, int hi) {
        if (lo > hi){
            return -1;
        }
        int mid = lo + (hi - lo)/2;
        if (key < a[mid]){
            return rank(key,a,lo,mid-1);
        }else if (key > a[mid]){
            return rank(key,a,mid + 1,hi);
        }else {
            return mid;
        }
    }

    public static void main(String[] args) {
//        System.out.println(isPrime(100));
//        System.out.println(sqrt(99));
//        System.out.println(Math.sqrt(-97));

//        int[] a = {15,5,165,165,651,10,15};
//        Arrays.sort(a);
//        System.out.println(rank(10,a));

//        System.out.println(System.currentTimeMillis());

//        System.out.println(StdRandom.uniform(100L));

//        100 ---
//        System.out.println(100 & 20);

//        StdOut.print(100 & 20);

//        System.out.format("%.2f\n",1235.021);
//        System.out.format("%.2f\n",Math.PI);

//        double sum = 0.0D;
//        int cnt = 0;
//        while (!StdIn.isEmpty()){
//            sum += StdIn.readDouble();
//            cnt ++;
//        }
//        double avg = sum / cnt;
//        StdOut.printf("Average is %.5f\n",avg);

//        int N = Integer.parseInt(args[0]);
//        double lo = Double.parseDouble(args[1]);
//        double hi = Double.parseDouble(args[2]);
//        for (int i = 0; i < N; i++) {
//            double x = StdRandom.uniform(lo,hi);
//            StdOut.printf("%.2f\n",x);
//        }

//        StdDraw.line(10.1,12.0,155.0,205.5);

//        int N = 100;
//        StdDraw.setXscale(0,N);
//        StdDraw.setYscale(0,N*N);
//        StdDraw.setPenRadius(0.01);
//        for (int i = 1; i <= N; i++) {
//            StdDraw.point(i,i);
//            StdDraw.point(i,i*i);
//            StdDraw.point(i,i*Math.log(i));
//        }

        int N = 50;
        double[] a = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        Arrays.sort(a);
        for (int i = 0; i < N; i++) {
            double x = 1.0*i/N;
            double y = a[i]/2.0;
            double rw = 0.5/N;
            double rh = a[i]/2.0;
            StdDraw.filledRectangle(x,y,rw,rh);
        }
    }
}
