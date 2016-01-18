package com.tobbyinside;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

/**
 * Created by tobby on 16/1/17.
 */
public class SortInsertion {

    //***************************排序算法***********************************
    public static void sort(Comparable[] a, boolean asc) {
        int N = a.length;
        for(int i = 1; i< N;i++){
            for(int j =0; j<i;j++){
                if(less(a[i],a[j])){
                    Comparable t = a[i];
                    for(int k = i;k>j;k--){
                        a[k] = a[k-1];
                    }
                    a[j] = t;
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
