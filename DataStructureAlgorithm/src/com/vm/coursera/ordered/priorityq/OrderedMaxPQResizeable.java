package com.vm.coursera.ordered.priorityq;

import java.util.NoSuchElementException;

import com.vm.utility.ArrayUtility;

public class OrderedMaxPQResizeable<Key extends Comparable<Key>> {
    private Comparable[] pq;
    private int N;

    /**
     * 
     * @param capacity
     */
    public OrderedMaxPQResizeable() {
        super();
        pq = (Key[]) new Comparable[2];
    }

    /**
     * 
     * @return
     */
    public boolean isEmpty() {
        return (N == 0);
    }

    /**
     * 
     * @param v
     */
    public void insert(Key v) {
        if (pq.length - 1 == N ) {
            resize(pq.length * 2);
        }
        pq[++N] = v;
        swim(N);
    }

    /**
     * 
     * @return
     */
    public Key delMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("PQ is empty");
        }
        Key max = (Key) pq[1];
        ArrayUtility.exch(pq, 1, N);
        pq[N] = null;
        N--;
        sink(1);
        if (N > 0 && N == (pq.length / 4)) {
            downsize(N, pq.length / 2);
        }
        return max;
    }

    /**
     * 
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && ArrayUtility.less(pq[k / 2], pq[k])) {
            ArrayUtility.exch(pq, k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 
     * @param k
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && ArrayUtility.less(pq[j], pq[j + 1])) {
                j++;
            }
            if (!ArrayUtility.less(pq[k], pq[j])) {
                break;
            }
            ArrayUtility.exch(pq, k, j);
            k = j;
        }
    }

    private void resize(int size) {
        Comparable[] temp = pq;
        int length = pq.length;
        pq = new Comparable[size];
        for (int i = 0; i < length; i++) {
            pq[i] = temp[i];
        }
        temp = null;
    }

    private void downsize(int length, int size) {
        Comparable[] temp = pq;
        pq = new Comparable[size];
        for (int i = 0; i <= length; i++) {
            pq[i] = temp[i];
        }
        temp = null;
    }

}
