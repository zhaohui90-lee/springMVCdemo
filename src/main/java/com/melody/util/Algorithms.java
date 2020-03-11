package com.melody.util;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import javax.xml.transform.Source;
import java.util.Arrays;

public class Algorithms {
    // 判断一个数是否为素数
    public static boolean isPrime(int N){
        if (N < 2) {
            return false;
        }
        for (int i = 2; i*i <= N; i++) {
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

    // 以2位底的对数函数
    public static int lg(int N){
        int num = 2,count = 1;
        while ((num*=2) <= N){
            count++;
        }
        return count;
    }

    // 以底数位E的对数从1到N相加
    public static double ln(int N){
        if (N == 0) return Math.log(1);
        return Math.log(N) + ln(--N);
    }

    // 欧几里得算法求最大公约数---除数和余数做循环除法，最终得到余数为0是的除数
    public static int gcd(int a,int b){
        if (a < b){
            int temp;
            temp = b;
            b = a;
            a = temp;
        }
        if (a % b == 0) return b;
        return gcd(b,a%b);
    }

    // 以2位底的指数函数
    public static int xxx(int N){
        int count = 1,result = 1;
        while (count <= N){
            result *= 2;
            count++;
        }
        return result;
    }

    static int num;

    public static void main(String[] args) {

//        System.out.println(ln(3));
//        System.out.println(gcd(1111111,1234567));
//        System.out.println(binomial(3,1,0.25));
        System.out.println(num);
    }

    public static String exR1(int N){
        if (N <= 0) return "";

        return exR1(N -3) + N + exR1(N - 2) + N;
    }

    public static int mystery(int a,int b){
        if (b == 0) return 1;
        if (b % 2 == 0) return mystery(a*a,b/2);
        return mystery(a*a,b/2) * a;
    }

    public static long F(int N){
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 1) + F(N -2);
    }

    public static double binomial(int N,int k,double p){
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0 - p)*binomial(N - 1,k,p) + p*binomial(N - 1,k-1,p);
    }
}
