package com.vm.coursera.unordered.priorityq;

/**
 * 
 * @author Venkatesh Manohar
 *
 * @param <Key>
 */
public class UnorderedMaxPQ<Key extends Comparable<Key>> {
    //Priority queue
    private Key[] pq;
    //number of elements in the q
    private int numberOfElements;
    /**
     * 
     * @param capacity
     */
    public UnorderedMaxPQ(int capacity) {
        super();
        pq = (Key[]) new Comparable[capacity];
    }
    /**
     * 
     * @param v
     */
    public void insert(Key v) {
        pq[numberOfElements++] = v;
    }
    /**
     * 
     * @return
     */
    public Key delMax() {
        int maxIndex = 0;
        for (int i = 1; i < numberOfElements; i++) {
            if (less(pq[maxIndex], pq[i])) {
                maxIndex = i;
            }
        }
        exch(pq, maxIndex, numberOfElements-1);
        
         
        return pq[--numberOfElements];
    }

    public boolean isEmpty() {
        return (numberOfElements == 0);
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

}
