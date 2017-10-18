package com.vm.sorting.selectionsort;

import static org.junit.Assert.*;

import org.junit.Test;

public class SelectionSortTest {

    private Integer[] integerArray = { 5, 4, 3, 2, 1 };

    @Test
    public void testEmptyArray() {
        Integer[] test = new Integer[0];
        Integer[] resultingArr = SelectionSort.sort(test);
        assertArrayEquals(resultingArr, test);
    }
    
    @Test
    public void test1ElementArray() {
        Integer[] test = {1};
        Integer[] resultingArr = SelectionSort.sort(test);
        assertEquals(resultingArr[0].intValue(), 1);
    }
    
    @Test
    public void test5ElementArray() {
        Integer[] resultingArr = SelectionSort.sort(integerArray);
        assertArrayEquals(resultingArr, integerArray);
    }

}
