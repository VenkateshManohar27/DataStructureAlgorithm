package com.vm.coursera.ordered.priorityq;

import java.util.NoSuchElementException;

import com.vm.utility.ArrayUtility;

public class OrderedMinPQ <Key extends Comparable<Key>> {
    private Comparable[] pq;
    private int N;

    /**
     * 
     * @param capacity
     */
    public OrderedMinPQ(final int capacity) {
        super();
        pq = (Key[]) new Comparable[capacity];
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
        pq[++N] = v;
        swim(N);
    }

    /**
     * 
     * @return
     */
    public Key delMin() {
        if(isEmpty()){
            throw new NoSuchElementException("PQ is empty");
        }
        Key max = (Key) pq[1];
        ArrayUtility.exch(pq, 1, N);
        pq[N] = null;
        N--;
        sink(1);
        return max;
    }

    /**
     * 
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && ArrayUtility.greater(pq[k / 2], pq[k])) {
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
            if (j < N && ArrayUtility.greater(pq[j], pq[j + 1])) {
                j++;
            }
            if (!ArrayUtility.greater(pq[k], pq[j])) {
                break;
            }
            ArrayUtility.exch(pq, k, j);
            k = j;
        }
    }

}
