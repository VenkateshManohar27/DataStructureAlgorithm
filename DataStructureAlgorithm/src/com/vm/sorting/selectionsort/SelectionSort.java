package com.vm.sorting.selectionsort;

import com.vm.sortingutility.SortingUtility;

/**
 * Even if the input is sorted Selection sort algorithms complexity is n^2.
 * 
 * @author Venkatesh Manohar
 *
 */
public final class SelectionSort {
    
    private SelectionSort(){
        super();
    }
    /**
     * 
     * @param array
     * @return sorted array
     */
    public static <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (SortingUtility.less(array[min], array[j])) {
                    min = j;
                }
            }
            SortingUtility.exch(array, i, min);
        }
        return array;
    }

}
