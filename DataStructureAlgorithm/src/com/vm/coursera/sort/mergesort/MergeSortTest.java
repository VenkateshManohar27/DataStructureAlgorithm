package com.vm.coursera.sort.mergesort;

import static org.junit.Assert.*;

import org.junit.Test;

public class MergeSortTest {

    private Integer[] integerArray = { 5, 4, 3, 2, 1 };

    @Test
    public void test5ElementsArray() {
        Comparable[] resultingArr = MergeSort.sort(integerArray);
        assertArrayEquals(resultingArr, integerArray);
    }

    @Test
    public void testHundredElementsWorstCase() {
        Integer[] inputArr = new Integer[100];

        for (int i = 0, j = 100; i < inputArr.length; i++, j--) {
            inputArr[i] = j;
        }
        Comparable[] resultingArr = MergeSort.sort(inputArr);
        assertEquals(resultingArr[0], Integer.valueOf(1));
        assertEquals(resultingArr[50], Integer.valueOf(51));
        assertEquals(resultingArr[99], Integer.valueOf(100));

    }

    @Test
    public void testTenThousandElementsWorstCase() {
        Integer[] inputArr = new Integer[10000];

        for (int i = 0, j = 10000; i < inputArr.length; i++, j--) {
            inputArr[i] = j;
        }

        Comparable[] resultingArr = MergeSort.sort(inputArr);

        assertEquals(resultingArr[0], new Integer(1));
        assertEquals(resultingArr[50], new Integer(51));
        assertEquals(resultingArr[99], new Integer(100));
        assertEquals(resultingArr[5999], new Integer(6000));
        assertEquals(resultingArr[7897], new Integer(7898));
        assertEquals(resultingArr[9999], new Integer(10000));

    }
    
    @Test
    public void testTenThousandElementsBestCase() {
        Integer[] inputArr = new Integer[10000];

        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = i;
        }

        Comparable[] resultingArr = MergeSort.sort(inputArr);

        assertEquals(resultingArr[0], new Integer(0));
        assertEquals(resultingArr[50], new Integer(50));
        assertEquals(resultingArr[99], new Integer(99));
        assertEquals(resultingArr[5999], new Integer(5999));
        assertEquals(resultingArr[7897], new Integer(7897));
        assertEquals(resultingArr[9999], new Integer(9999));

    }
}
