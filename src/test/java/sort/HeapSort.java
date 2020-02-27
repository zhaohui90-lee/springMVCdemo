package sort;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 堆排序
 */
public class HeapSort {
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int k = N/2 -1; k >=0 ; k--) {
            sink(a,k,N);
        }
        for (int i = N - 1; i > 0; i--) {
            exch(a,0,i);
            sink(a,0,i); // 排序为根节点为最小值
        }
    }

    private static void sink(Comparable[] a, int i, int length) {
        for (int k = 2*i+1; k < length; k = 2*k+1) {
            if (k+1 < length && less(a,k,k+1)){
                k++;
            }
            if (!less(a,k,i)){
                exch(a,i,k);
                 i = k;
            }else {
                break;
            }
        }
    }

    private static boolean less(Comparable[] a, int before, int after) {
        return a[before].compareTo(a[after]) < 0;
    }
    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 选择排序-堆排序
     * @param array 待排序数组
     */
    public static void heapSort(Comparable[] array) {
        //这里元素的索引是从0开始的,所以最后一个非叶子结点array.length/2 - 1
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);  //调整堆
        }

        // 上述逻辑，建堆结束
        // 下面，开始排序逻辑
        for (int j = array.length - 1; j > 0; j--) {
            // 元素交换,作用是去掉大顶堆
            // 把大顶堆的根元素，放到数组的最后；换句话说，就是每一次的堆调整之后，都会有一个元素到达自己的最终位置
            swap(array, 0, j);
            // 元素交换之后，毫无疑问，最后一个元素无需再考虑排序问题了。
            // 接下来我们需要排序的，就是已经去掉了部分元素的堆了，这也是为什么此方法放在循环里的原因
            // 而这里，实质上是自上而下，自左向右进行调整的
            adjustHeap(array, 0, j);
        }
    }

    /**
     * 整个堆排序最关键的地方
     * @param array 待组堆
     * @param i 起始结点
     * @param length 堆的长度
     */
    public static void adjustHeap(Comparable[] array, int i, int length) {
        // 先把当前元素取出来，因为当前元素可能要一直移动
        Comparable temp = array[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {  //2*i+1为左子树i的左子树(因为i是从0开始的),2*k+1为k的左子树
            // 让k先指向子节点中最大的节点
            if (k + 1 < length && array[k].compareTo(array[k + 1])<0) {  //如果有右子树,并且右子树大于左子树
                k++;
            }
            //如果发现结点(左右子结点)大于根结点，则进行值的交换
            if (array[k].compareTo(temp)>0) {
                swap(array, i, k);
                // 如果子节点更换了，那么，以子节点为根的子树会受到影响,所以，循环对子节点所在的树继续进行判断
                i  =  k;
            } else {  //不用交换，直接终止循环
                break;
            }
        }
    }

    /**
     * 交换元素
     * @param arr
     * @param a 元素的下标
     * @param b 元素的下标
     */
    public static void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Double[] a = new Double[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform()*100000;
        }
        for (Double d : a) {
            System.out.print(d + ",");
        }
        System.out.println();
        Stopwatch timer = new Stopwatch();
        sort(a); //
//        heapSort(a);
        for (Double d : a) {
            System.out.print(d + ",");
        }
        double time = timer.elapsedTime();
        System.out.println("time: " + time + " seconds");
    }
}
