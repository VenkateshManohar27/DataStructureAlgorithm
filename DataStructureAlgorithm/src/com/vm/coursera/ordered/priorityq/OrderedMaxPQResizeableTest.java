package com.vm.coursera.ordered.priorityq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class OrderedMaxPQResizeableTest {
    private OrderedMaxPQResizeable<Integer> maxpq;

    @Before
    public void initialize() {
        maxpq = new OrderedMaxPQResizeable<>();
    }

    @Test
    public void TestIsEmpty() {
        assertTrue(maxpq.isEmpty());
    }
    
    @Test(expected = NoSuchElementException.class)
    public void TestDeleteOnEmptyPQ() {
        maxpq.delMax();
    }

    @Test
    public void TestMaxWithOneElement() {
        maxpq.insert(1);
        assertFalse(maxpq.isEmpty());
        assertEquals(maxpq.delMax(), Integer.valueOf(1));
        assertTrue(maxpq.isEmpty());
    }

    @Test
    public void TestMaxWithFiveElement() {
        maxpq.insert(1);
        maxpq.insert(5);
        maxpq.insert(3);
        maxpq.insert(2);
        maxpq.insert(4);
        assertFalse(maxpq.isEmpty());
        assertEquals(maxpq.delMax(), Integer.valueOf(5));
        assertFalse(maxpq.isEmpty());
        
        assertFalse(maxpq.isEmpty());
        assertEquals(maxpq.delMax(), Integer.valueOf(4));
        assertFalse(maxpq.isEmpty());
        
        assertFalse(maxpq.isEmpty());
        assertEquals(maxpq.delMax(), Integer.valueOf(3));
        assertFalse(maxpq.isEmpty());
        
        assertFalse(maxpq.isEmpty());
        assertEquals(maxpq.delMax(), Integer.valueOf(2));
        assertFalse(maxpq.isEmpty());
        
        assertFalse(maxpq.isEmpty());
        assertEquals(maxpq.delMax(), Integer.valueOf(1));
        assertTrue(maxpq.isEmpty());
    }
}
