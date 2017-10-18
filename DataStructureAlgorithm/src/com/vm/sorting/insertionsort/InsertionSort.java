package com.vm.sorting.insertionsort;

import com.vm.sortingutility.SortingUtility;

/**
 * 
 * @author Venkatesh Manohar
 *
 */
public class InsertionSort {

    
    public static <T extends Comparable<T>> T[] sort(T[] a) {

        int counter = 0;
        int exchanges = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                ++counter;
                if (SortingUtility.less(a[j], a[j - 1])) {
                    ++exchanges;
                    SortingUtility.exch(a, j, j - 1);
                } else {
                    break;
                }
            }
        }

        System.out.println("For Array of size " + a.length
                + ", The inner loop runs " + counter + " times and it requires "
                + exchanges + " exchanges.");
        return a;
    }
}
