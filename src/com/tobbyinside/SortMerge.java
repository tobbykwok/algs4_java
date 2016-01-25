package com.tobbyinside;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 归并排序
 * Created by tobby on 16/1/22.
 */
public class SortMerge {

    //*************************** 自底向上归并排序 *******************************

    public static void sort_bottom2top(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int sz = 1; sz < N; sz += sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    // ************************* 自顶向下归并排序 ********************************
    public static void sort_top2bottom(Comparable[] a, boolean asc) {
        Comparable[] aux = new Comparable[a.length];
        sort_top2bottom(a, aux, 0, a.length - 1);
    }

    private static void sort_top2bottom(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort_top2bottom(a, aux, lo, mid);
        sort_top2bottom(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }
    // ************************************************************************


    /**
     * 原地归并
     *
     * @param a   源
     * @param aux 辅助数组
     * @param lo  起始index
     * @param mid 中间index
     * @param hi  尾部index
     * @tag 自顶向下/自底向上归并排序都要用到此方法
     */
    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        int low_offset = lo, mid_offset = mid + 1;

        for (int i = lo; i <= hi; i++) {        // i: 目标数组位置
            // 先检查offset边界
            if (low_offset > mid) {
                a[i] = aux[mid_offset++];
            } else if (mid_offset > hi) {
                a[i] = aux[low_offset++];
            }//再检查low_offset与mid_offset当前位置大小
            else if (less(aux[mid_offset], aux[low_offset])) {
                a[i] = aux[mid_offset++];
            } else {
                a[i] = aux[low_offset++];
            }
        }
    }

    //*********************************************************************

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
        sort_bottom2top(a);
        assert isSorted(a, true);
        show(a);
    }
}
