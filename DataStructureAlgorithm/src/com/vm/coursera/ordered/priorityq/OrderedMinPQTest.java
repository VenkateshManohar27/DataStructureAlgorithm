package com.vm.coursera.ordered.priorityq;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class OrderedMinPQTest {
    private OrderedMinPQ<Integer> minpq;

    @Before
    public void initialize() {
        minpq = new OrderedMinPQ<>(10);
    }

    @Test
    public void TestIsEmpty() {
        assertTrue(minpq.isEmpty());
    }
    
    @Test(expected = NoSuchElementException.class)
    public void TestDeleteOnEmptyPQ() {
        minpq.delMin();
    }

    @Test
    public void TestMaxWithOneElement() {
        minpq.insert(1);
        assertFalse(minpq.isEmpty());
        assertEquals(minpq.delMin(), Integer.valueOf(1));
        assertTrue(minpq.isEmpty());
    }

    @Test
    public void TestMaxWithFiveElement() {
        minpq.insert(1);
        minpq.insert(5);
        minpq.insert(3);
        minpq.insert(2);
        minpq.insert(4);
        assertFalse(minpq.isEmpty());
        assertEquals(minpq.delMin(), Integer.valueOf(1));
        assertFalse(minpq.isEmpty());
        
        assertFalse(minpq.isEmpty());
        assertEquals(minpq.delMin(), Integer.valueOf(2));
        assertFalse(minpq.isEmpty());
        
        assertFalse(minpq.isEmpty());
        assertEquals(minpq.delMin(), Integer.valueOf(3));
        assertFalse(minpq.isEmpty());
        
        assertFalse(minpq.isEmpty());
        assertEquals(minpq.delMin(), Integer.valueOf(4));
        assertFalse(minpq.isEmpty());
        
        assertFalse(minpq.isEmpty());
        assertEquals(minpq.delMin(), Integer.valueOf(5));
        assertTrue(minpq.isEmpty());
    }


}
