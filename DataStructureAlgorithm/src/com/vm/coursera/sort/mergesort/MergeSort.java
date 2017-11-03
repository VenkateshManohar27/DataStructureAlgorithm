package com.vm.coursera.sort.mergesort;

public class MergeSort {

    private static void merge(Comparable[] input, Comparable[] aux, int low,
            int mid, int high) {
        int i = low;
        int j = mid + 1;
        for (int k = 0; k <= high; k++) {
            aux[k] = input[k];
        }
        for (int index = low; index <= high; index++) {
            if (i > mid) {
                input[index] = aux[j++];
            } else if (j > high) {
                input[index] = aux[i++];
            } else if (less(aux[i], aux[j])) {
                input[index] = aux[i++];
            } else {
                input[index] = aux[j++];
            }
        }

    }

    private static void sort(Comparable[] input, Comparable[] aux, int low,
            int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(input, aux, low, mid);
        sort(input, aux, mid + 1, high);
        merge(input, aux, low, mid, high);
    }

    public static <T extends Comparable<T>> Comparable[] sort(T[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
        return a;
    }

    /**
     * 
     * @param obj1
     *            - Object source
     * @param obj2
     *            - object which is compared to source
     * @return true if obj1 is less than obj2.
     */
    public static boolean less(final Comparable obj1, final Comparable obj2) {
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
    public static void exch(final Comparable[] array, final int i,
            final int j) {
        Comparable swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }

}
