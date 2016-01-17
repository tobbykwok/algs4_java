package com.tobbyinside;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

/**
 * Created by tobby on 16/1/17.
 */
public class SortSelection {

    //***************************排序算法***********************************
    public static void sort(Comparable[] a, boolean asc) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;    // 记录最小值下标啊傻逼!!
            for (int j = i + 1; j < N ; j++) {  // 从 i+1 开始遍历直到最后
                if(less(a[j], a[min])){           // 每次与遍历过的最小值比较啊傻逼!!!! 傻逼啊!!!
                    min = j;
                }
            }
            exch(a, i, min);                    // 一次遍历后, 将找到的最小值与当前遍历起始值交换
        }
    }
    //*********************************************************************

    public static void sort(Comparable[] a) {
        sort(a, true);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        // print all elements
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        return isSorted(a, true);
    }

    public static boolean isSorted(Comparable[] a, boolean asc) {
        for (int i = 1; i < a.length; i++) {
            if (asc) {
                if (less(a[i], a[i - 1])) {
                    return false;
                }
            } else {
                if (!less(a[i], a[i - 1])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a, true);
        assert isSorted(a, true);
        show(a);
    }
}
