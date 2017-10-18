package com.vm.sortingutility;

/**
 * 
 * @author Venkatesh Manohar
 *
 */
public class SortingUtility {
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
