package com.tobbyinside;

/**
 * Created by tobby on 16/2/9.
 */
public class IndexMinPQ<Key extends Comparable<Key>> {
    private int maxN;
    private int N;
    private int[] pq;
    private int[] qp;
    private Key[] keys;

    public IndexMinPQ(int maxN) {
        keys = (Key[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++) qp[i] = -1;
    }

    public void insert(int k, Key key) {
        N++;
        qp[k] = N;
        pq[N] = k;
        keys[k] = key;
        swim(N);
    }

    public void change(int k, Key key) {
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }

    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public void delete(int k) {
        int index = qp[k];
        exch(index, N--);
        swim(index);
        sink(index);
        keys[k] = null;
        qp[k] = -1;
    }

    public Key min() {
        return keys[pq[1]];
    }

    public int minIndex() {
        return pq[1];
    }

    public int delMin() {
        int indexOfMin = pq[1];
        exch(1, N--);
        sink(1);
        keys[pq[N + 1]] = null;
        qp[pq[N + 1]] = -1;
        return indexOfMin;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void exch(int i, int j) {
        Key t = keys[pq[i]];
        keys[pq[i]] = keys[pq[j]];
        keys[pq[j]] = t;
    }

    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    private void swim(int k) {
        int index = pq[k];
        while (index > 1 && less(index / 2, index)) {
            exch(index / 2, index);
            index /= 2;
        }
    }

    private void sink(int k) {
        int index = pq[k];
        while (2 * index <= N) {
            int childIndex = index * 2;
            if (childIndex < N && less(childIndex, childIndex + 1)) childIndex++;
            if (!less(index, childIndex)) break;
            exch(index, childIndex);
            index = childIndex;
        }
    }


}
