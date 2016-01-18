package com.tobbyinside;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by tobby on 16/1/19.
 */
public class SortShell {

    //***************************排序算法***********************************
    public static void sort(Comparable[] a, boolean asc) {
        int N = a.length;
        for (int Increment = N / 2; Increment > 0; Increment /= 2) {
            for (int i = Increment; i < N; i++) {
                for (int j = i; j >= Increment; j -= Increment) {
                    if(less(a[j], a[j-Increment])){
                        exch(a, j, j-Increment);
                    }else{
                        break;
                    }
                }
            }
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
