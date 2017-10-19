package com.vm.sorting.shellsort;

import com.vm.sortingutility.SortingUtility;

/**
 * 
 * @author Venkatesh Manohar
 *
 */
public class ShellSort {

    public static <T extends Comparable<T>> T[] sort(T[] arr) {
        int h = 1;
        int n = arr.length;
        int counter = 0;
        int exchanges = 0;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        System.out.println("H is " + h);
        while (h >= 1) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h; j -= h ) {
                    counter++;
                    if (SortingUtility.less(arr[j], arr[j - h])) {
                        ++exchanges;
                        SortingUtility.exch(arr, j, j - h);
                    } else {
                        break;
                    }
                }
            }
            h /= 3;
            System.out.println("H is " + h);
        }

        System.out.println("For Array of size " + arr.length
                + ", The inner loop runs " + counter + " times and it requires "
                + exchanges + " exchanges.");

        return arr;
    }
}
