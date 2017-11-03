package com.vm.sorting.quicksort;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {

    public static <T extends Comparable<T>> Comparable[] sort(
            T[] integerArray) {
        StdRandom.shuffle(integerArray);
        sort(integerArray, 0, integerArray.length - 1);
        return integerArray;
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo])) {
                if (i == hi) {
                    break;
                }
            }

            while (less(a[lo], a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void sort(Comparable[] integerArray, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int j = partition(integerArray, lo, hi);
        sort(integerArray, lo, j - 1);
        sort(integerArray, j + 1, hi);
    }

    /**
     * 
     * @param obj1
     *            - Object source
     * @param obj2
     *            - object which is compared to source
     * @return true if obj1 is less than obj2.
     */
    private static boolean less(final Comparable obj1, final Comparable obj2) {
        return obj1.compareTo(obj2) < 0;
    }

    /**
     * Code for swapping the array elements.
     * 
     * @param array
     *            - array of comparable.
     * @param i
     *            index i.
     * @param j
     *            index j.
     */
    private static void exch(final Comparable[] array, final int i,
            final int j) {
        Comparable swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }

    public static void main(String[] args) {
        Integer[] integerArray = { 5, 4, 3, 2, 1 };
        
        sort(integerArray);
        for (int i : integerArray) {
            System.out.println(i + ",");
        }
    }

}
