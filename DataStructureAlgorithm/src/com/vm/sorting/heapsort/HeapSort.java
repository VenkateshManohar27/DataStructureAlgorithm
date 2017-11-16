package com.vm.sorting.heapsort;

import com.vm.utility.ArrayUtility;

public class HeapSort {

    public static Comparable[] sort(Comparable[] arr) {
        int N = arr.length;

        for (int i = N / 2; i > 0; i--) {
            sink(arr, i, N);
        }
        while (N > 1) {
            exch(arr, 1, N--);
            sink(arr, 1, N);
        }
        return arr;
    }

    private static void sink(Comparable[] arr, int i, int n) {

        while (2 * i <= n) {
            int j = 2 * i;
            if (j + 1 < n && less(arr, j, j + 1)) {
                j++;
            }
            if (!less(arr, i, j)) {
                break;
            }
            exch(arr, i, j);
            i = j;
        }

    }

    /***************************************************************************
     * Helper functions for comparisons and swaps. Indices are "off-by-one" to
     * support 1-based indexing.
     ***************************************************************************/
    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i - 1].compareTo(pq[j - 1]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = swap;
    }

}
