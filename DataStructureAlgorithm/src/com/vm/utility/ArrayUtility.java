package com.vm.utility;

public class ArrayUtility {

    public static int[] initializeAsc(int length) {
        int[] result = new int[length];
        for (int i = 1; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }

    public static int[] initializeDesc(int length) {
        int[] result = new int[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = length--;
        }
        return result;
    }

    public static void print(int arr[]) {
        System.out.println("Array is : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " |");
        }
        System.out.println();
    }

    public static void printWithIndex(int arr[]) {
        System.out.println("Array is : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + " |");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " |");
        }
        System.out.println();
    }

    public static void print(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println();
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
     * 
     * @param obj1
     *            - Object source
     * @param obj2
     *            - object which is compared to source
     * @return true if obj1 is greater than obj2.
     */
    public static boolean greater(final Comparable obj1,
            final Comparable obj2) {
        return obj1.compareTo(obj2) > 0;
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
    public static void exchForHeap(final Comparable[] array, final int i,
            final int j) {
        Comparable swap = array[i];
        array[i] = array[j - 1];
        array[j - 1] = swap;
    }
}
