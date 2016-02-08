package com.tobbyinside;

/**
 * Created by tobby on 16/2/8.
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[j];
        pq[j] = pq[i];
        pq[i] = temp;
    }

    /**
     * !!! 上浮方法
     *
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }
    }

    /**
     * !!! 下沉方法
     *
     * @param k
     */
    private void sink(int k) {
        while (2 * k <= N) {                    // N 是元素个数, 数组最后一个位置的索引为N-1
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;   // 获得两个子节点中较大的下标
            if (less(k, j)) {
                exch(k, j);
                k = j;
            } else {
                break;
            }
        }
    }
}
