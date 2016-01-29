package com.tobbyinside;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

/**
 * Created by tobby on 16/1/25.
 */
public class SortFast {
    private static Random random;

    public static void SortFast() {
        random = new Random();
    }

    public static void sort(Comparable[] a) {
        shuffleArray(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(a, lo, hi);
        sort(a, lo, p - 1);
        sort(a, p + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;   //目的是从左到右找到最后一个小于v的位置
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }


    // -------------- Auxiliary functions

    private static void shuffleArray(Object[] a) {
        if (a == null) throw new NullPointerException("Parameter a can not be null");
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int new_offset = i + random.nextInt(N - i);
            Object temp = a[i];
            a[i] = a[new_offset];
            a[new_offset] = temp;
        }
    }

    // --------------
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
        SortFast();
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a, true);
        show(a);
    }
}
