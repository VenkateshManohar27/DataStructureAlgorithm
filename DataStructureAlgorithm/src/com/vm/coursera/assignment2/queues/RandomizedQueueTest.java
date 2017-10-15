package com.vm.coursera.assignment2.queues;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class RandomizedQueueTest {

    @Test
    public void randomizedQueueContruction() {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        assertTrue(rq.isEmpty());
        assertEquals(0, rq.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void randomizedQueueEnqueueNull() {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        assertTrue(rq.isEmpty());
        assertEquals(0, rq.size());
        rq.enqueue(null);

    }

    @Test
    public void randomizedQueueEnqueue1item() {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        assertTrue(rq.isEmpty());
        assertEquals(0, rq.size());
        rq.enqueue("1");
        assertFalse(rq.isEmpty());
        assertEquals(1, rq.size());
    }

    @Test
    public void randomizedQueueEnqueue1itemSampleTest() {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        assertTrue(rq.isEmpty());
        assertEquals(0, rq.size());
        rq.enqueue("1");
        assertFalse(rq.isEmpty());
        assertEquals(1, rq.size());
        assertNotNull(rq.sample());
    }

    @Test
    public void randomizedQueueEnqueue2item() {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        assertTrue(rq.isEmpty());
        assertEquals(0, rq.size());
        rq.enqueue("1");
        assertFalse(rq.isEmpty());
        assertEquals(1, rq.size());
        rq.enqueue("2");
        assertFalse(rq.isEmpty());
        assertEquals(2, rq.size());
    }

    @Test
    public void randomizedQueueEnqueue4itemTest() {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        assertTrue(rq.isEmpty());
        assertEquals(0, rq.size());
        rq.enqueue("1");
        rq.enqueue("2");
        rq.enqueue("3");
        rq.enqueue("4");
        assertFalse(rq.isEmpty());
        assertEquals(4, rq.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void randomizedQueueEmptyDequeueTest() {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        assertTrue(rq.isEmpty());
        assertEquals(0, rq.size());
        rq.dequeue();
    }

    @Test(expected = NoSuchElementException.class)
    public void randomizedQueueEmptySampleTest() {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        assertTrue(rq.isEmpty());
        assertEquals(0, rq.size());
        rq.sample();
    }

    @Test
    public void randomizedQueueEnqueue4itemDequeue2ItemsTest() {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        assertTrue(rq.isEmpty());
        assertEquals(0, rq.size());
        rq.enqueue("1");
        rq.enqueue("2");
        rq.enqueue("3");
        rq.enqueue("4");
        assertFalse(rq.isEmpty());
        assertEquals(4, rq.size());

        assertNotNull(rq.dequeue());
        assertFalse(rq.isEmpty());
        assertEquals(3, rq.size());

        assertNotNull(rq.dequeue());
        assertFalse(rq.isEmpty());
        assertEquals(2, rq.size());
    }

    @Test
    public void randomizedQueueEnqueue4itemDequeue4ItemsTest() {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        assertTrue(rq.isEmpty());
        assertEquals(0, rq.size());
        rq.enqueue("1");
        rq.enqueue("2");
        rq.enqueue("3");
        rq.enqueue("4");
        assertFalse(rq.isEmpty());
        assertEquals(4, rq.size());

        assertNotNull(rq.dequeue());
        assertFalse(rq.isEmpty());
        assertEquals(3, rq.size());

        assertNotNull(rq.dequeue());
        assertFalse(rq.isEmpty());
        assertEquals(2, rq.size());

        assertNotNull(rq.dequeue());
        assertFalse(rq.isEmpty());
        assertEquals(1, rq.size());

        assertNotNull(rq.dequeue());
        assertTrue(rq.isEmpty());
        assertEquals(0, rq.size());
    }

    @Test
    public void randomizedQueueEnqueue4itemSample4Test() {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        assertTrue(rq.isEmpty());
        assertEquals(0, rq.size());
        rq.enqueue("1");
        rq.enqueue("2");
        rq.enqueue("3");
        rq.enqueue("4");
        assertFalse(rq.isEmpty());
        assertEquals(4, rq.size());

        assertNotNull(rq.sample());
        assertFalse(rq.isEmpty());
        assertEquals(4, rq.size());

        assertNotNull(rq.sample());
        assertFalse(rq.isEmpty());
        assertEquals(4, rq.size());

        assertNotNull(rq.sample());
        assertFalse(rq.isEmpty());
        assertEquals(4, rq.size());

        assertNotNull(rq.sample());
        assertFalse(rq.isEmpty());
        assertEquals(4, rq.size());
    }

    @Test
    public void randomizedQueueIteratorTest() {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        assertTrue(rq.isEmpty());
        assertEquals(0, rq.size());
        rq.enqueue("1");
        rq.enqueue("2");
        rq.enqueue("3");
        rq.enqueue("4");
        assertFalse(rq.isEmpty());
        assertEquals(4, rq.size());
        Iterator<String> it = rq.iterator();

        while (it.hasNext()) {
            assertNotNull(it.next());
        }
        assertFalse(rq.isEmpty());
        assertEquals(4, rq.size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void randomizedQueueIteratorRemoveTest() {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        assertTrue(rq.isEmpty());
        assertEquals(0, rq.size());
        Iterator<String> it = rq.iterator();
        it.remove();
    }

    @Test
    public void randomizedQueueIteratorforeachTest() {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        assertTrue(rq.isEmpty());
        assertEquals(0, rq.size());
        rq.enqueue("1");
        rq.enqueue("2");
        rq.enqueue("3");
        rq.enqueue("4");
        assertFalse(rq.isEmpty());
        assertEquals(4, rq.size());
        for (String s : rq) {
            assertNotNull(s);
        }

        assertFalse(rq.isEmpty());
        assertEquals(4, rq.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void randomizedQueueIteratorNextTest() {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        assertTrue(rq.isEmpty());
        assertEquals(0, rq.size());
        Iterator<String> it = rq.iterator();
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void randomizedQueueIteratorNext1ElementTest() {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        assertTrue(rq.isEmpty());
        assertEquals(0, rq.size());
        rq.enqueue("1");
        assertFalse(rq.isEmpty());
        assertEquals(1, rq.size());
        Iterator<String> it = rq.iterator();
        it.next();
        it.next();
    }

    @Test
    public void randomizedQueueRandomTestsFromPrincetonTest() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        rq.enqueue(309);
        assertFalse(rq.isEmpty());
        assertEquals(1, rq.size());
        
        assertNotNull(rq.dequeue());
        assertTrue(rq.isEmpty());
        assertEquals(0, rq.size());
        
        rq.enqueue(341);
        rq.enqueue(88);
        assertFalse(rq.isEmpty());
        assertEquals(2, rq.size());
        
        assertNotNull(rq.dequeue());
        assertFalse(rq.isEmpty());
        assertEquals(1, rq.size());
        assertNotNull(rq.sample());
    }
    
    @Test
    public void randomizedQueueIterator10ItemsTest() {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        assertTrue(rq.isEmpty());
        assertEquals(0, rq.size());
        rq.enqueue("1");
        rq.enqueue("2");
        rq.enqueue("3");
        rq.enqueue("4");
        rq.enqueue("5");
        rq.enqueue("6");
        rq.enqueue("7");
        rq.enqueue("8");
        rq.enqueue("9");
        rq.enqueue("10");
        assertFalse(rq.isEmpty());
        assertEquals(10, rq.size());
        int i = 0;
        for (String s : rq) {
            i++;
            assertNotNull(s);
        }
        assertEquals(10,i);
        
        assertFalse(rq.isEmpty());
        assertEquals(10, rq.size());
    }

    
    @Test
    public void randomizedQueueIteratorEmptyTest() {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        assertTrue(rq.isEmpty());
        assertEquals(0, rq.size());
        int i = 0;
        for (String s : rq) {
            i++;
            assertNotNull(s);
        }
        assertEquals(0,i);
    }
    
    @Test
    public void randomizedQueueIteratorEnqueueDequeueTest() {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        assertTrue(rq.isEmpty());
        assertEquals(0, rq.size());
        rq.enqueue("1");
        rq.enqueue("2");
        rq.enqueue("3");
        rq.enqueue("4");
        rq.enqueue("5");
        rq.enqueue("6");
        rq.enqueue("7");
        rq.enqueue("8");
        rq.enqueue("9");
        rq.enqueue("10");
        assertFalse(rq.isEmpty());
        assertEquals(10, rq.size());
        int i = 0;
        for (String s : rq) {
            i++;
            assertNotNull(s);
        }
        assertEquals(10,i);
        
        assertFalse(rq.isEmpty());
        assertEquals(10, rq.size());
        
        assertNotNull(rq.dequeue());
        assertNotNull(rq.dequeue());
        assertNotNull(rq.dequeue());
        assertNotNull(rq.dequeue());
        
        assertFalse(rq.isEmpty());
        assertEquals(6, rq.size());
        i = 0;
        for (String s : rq) {
            i++;
            assertNotNull(s);
        }
        assertEquals(6,i);
    }
}
