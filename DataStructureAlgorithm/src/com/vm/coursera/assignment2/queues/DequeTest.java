package com.vm.coursera.assignment2.queues;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class DequeTest {

	@Test
	public void dequeConstructionTest() {
		Deque<String> test = new Deque<String>();
		assertTrue(test.isEmpty());
	}

	@Test(expected = NoSuchElementException.class)
	public void emptyDequeIterationTest() {
		Deque<String> test = new Deque<String>();
		assertTrue(test.isEmpty());
		Iterator<String> i = test.iterator();
		i.next();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void emptyDequeIteratorRemoveTest() {
		Deque<String> test = new Deque<String>();
		assertTrue(test.isEmpty());
		Iterator<String> i = test.iterator();
		i.remove();
	}

	@Test(expected = IllegalArgumentException.class)
	public void addFirstExceptionDequeTest() {
		Deque<String> dq = new Deque<String>();
		dq.addFirst(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void addLastExceptionDequeTest() {
		Deque<String> dq = new Deque<String>();
		dq.addLast(null);
	}

	@Test(expected = NoSuchElementException.class)
	public void removeFirstExceptionDequeTest() {
		Deque<String> dq = new Deque<String>();
		dq.removeFirst();
	}

	@Test(expected = NoSuchElementException.class)
	public void removeLastExceptionDequeTest() {
		Deque<String> dq = new Deque<String>();
		dq.removeLast();
	}

	@Test
	public void addFirstOnEmptyDequeTest() {
		Deque<String> dq = new Deque<String>();
		dq.addFirst("First");
		assertFalse(dq.isEmpty());
		assertEquals(1, dq.size());
	}

	@Test
	public void addLastOnEmptyDequeTest() {
		Deque<String> dq = new Deque<String>();
		dq.addLast("Last");
		assertFalse(dq.isEmpty());
		assertEquals(1, dq.size());

	}

	@Test
	public void addFirst2ElementsDequeTest() {
		Deque<String> dq = new Deque<String>();
		dq.addFirst("First");
		assertFalse(dq.isEmpty());
		dq.addFirst("second");
		assertFalse(dq.isEmpty());
		assertEquals(2, dq.size());
	}

	@Test
	public void addLast2ElementDequeTest() {
		Deque<String> dq = new Deque<String>();
		dq.addLast("Last");
		assertFalse(dq.isEmpty());
		dq.addFirst("lastsecond");
		assertFalse(dq.isEmpty());
		assertEquals(2, dq.size());

	}

	@Test
	public void addFirstRemoveFirst1ElementDequeTest() {
		Deque<String> dq = new Deque<String>();
		dq.addFirst("First");
		assertFalse(dq.isEmpty());
		assertEquals(1, dq.size());
		assertEquals("First", dq.removeFirst());
		assertEquals(0, dq.size());
		assertTrue(dq.isEmpty());
	}

	@Test
	public void addFirstRemoveFirst2ElementDequeTest() {
		Deque<String> dq = new Deque<String>();
		dq.addFirst("First");
		assertFalse(dq.isEmpty());
		assertEquals(1, dq.size());
		dq.addFirst("Second");
		assertFalse(dq.isEmpty());
		assertEquals(2, dq.size());

		assertEquals("Second", dq.removeFirst());
		assertEquals(1, dq.size());
		assertFalse(dq.isEmpty());
		assertEquals("First", dq.removeFirst());
		assertEquals(0, dq.size());
		assertTrue(dq.isEmpty());
	}

	@Test
	public void addLastRemoveFirst1ElementDequeTest() {
		Deque<String> dq = new Deque<String>();
		dq.addLast("First");
		assertFalse(dq.isEmpty());
		assertEquals(1, dq.size());
		assertEquals("First", dq.removeLast());
		assertEquals(0, dq.size());
		assertTrue(dq.isEmpty());
	}

	@Test
	public void addLastRemoveLast2ElementDequeTest() {
		Deque<String> dq = new Deque<String>();
		dq.addLast("First");
		assertFalse(dq.isEmpty());
		assertEquals(1, dq.size());
		dq.addLast("Second");
		assertFalse(dq.isEmpty());
		assertEquals(2, dq.size());

		assertEquals("Second", dq.removeLast());
		assertEquals(1, dq.size());
		assertFalse(dq.isEmpty());
		assertEquals("First", dq.removeLast());
		assertEquals(0, dq.size());
		assertTrue(dq.isEmpty());
	}

	@Test
	public void randomAddRemove2ElementsDequeTest() {
		Deque<String> dq = new Deque<String>();
		dq.addFirst("First");
		assertFalse(dq.isEmpty());
		assertEquals(1, dq.size());
		dq.addLast("Second");
		assertFalse(dq.isEmpty());
		assertEquals(2, dq.size());

		assertEquals("First", dq.removeFirst());
		assertEquals(1, dq.size());
		assertFalse(dq.isEmpty());
		assertEquals("Second", dq.removeLast());
		assertEquals(0, dq.size());
		assertTrue(dq.isEmpty());
	}

	@Test
	public void randomAddRemove3ElementsDequeTest() {
		Deque<String> dq = new Deque<String>();
		dq.addFirst("First");
		assertFalse(dq.isEmpty());
		assertEquals(1, dq.size());
		dq.addLast("Second");
		assertFalse(dq.isEmpty());
		assertEquals(2, dq.size());
		dq.addFirst("Third");
		assertFalse(dq.isEmpty());
		assertEquals(3, dq.size());

		assertEquals("Third", dq.removeFirst());
		assertEquals(2, dq.size());
		assertFalse(dq.isEmpty());
		assertEquals("Second", dq.removeLast());
		assertEquals(1, dq.size());
		assertFalse(dq.isEmpty());
		assertEquals("First", dq.removeFirst());
		assertEquals(0, dq.size());
		assertTrue(dq.isEmpty());
	}

	@Test
	public void randomAddRemove4ElementsDequeTest() {
		Deque<String> dq = new Deque<String>();
		dq.addFirst("First");
		assertFalse(dq.isEmpty());
		assertEquals(1, dq.size());
		dq.addLast("Second");
		assertFalse(dq.isEmpty());
		assertEquals(2, dq.size());
		dq.addFirst("Third");
		assertFalse(dq.isEmpty());
		assertEquals(3, dq.size());
		dq.addLast("Four");
		assertFalse(dq.isEmpty());
		assertEquals(4, dq.size());

		assertEquals("Third", dq.removeFirst());
		assertEquals(3, dq.size());
		assertFalse(dq.isEmpty());
		assertEquals("Four", dq.removeLast());
		assertEquals(2, dq.size());
		assertFalse(dq.isEmpty());
		assertEquals("First", dq.removeFirst());
		assertEquals(1, dq.size());
		assertFalse(dq.isEmpty());
		assertEquals("Second", dq.removeFirst());
		assertEquals(0, dq.size());
		assertTrue(dq.isEmpty());
	}

	@Test
	public void randomAddRemove5ElementsDequeTest() {
		Deque<String> dq = new Deque<String>();
		dq.addFirst("First");
		assertFalse(dq.isEmpty());
		assertEquals(1, dq.size());
		dq.addLast("Second");
		assertFalse(dq.isEmpty());
		assertEquals(2, dq.size());
		dq.addFirst("Third");
		assertFalse(dq.isEmpty());
		assertEquals(3, dq.size());
		dq.addLast("Four");
		assertFalse(dq.isEmpty());
		assertEquals(4, dq.size());
		dq.addFirst("fifth");
		assertFalse(dq.isEmpty());
		assertEquals(5, dq.size());

		assertEquals("fifth", dq.removeFirst());
		assertEquals(4, dq.size());
		assertFalse(dq.isEmpty());
		Iterator<String> i = dq.iterator();
		if (i.hasNext()) {
			String s = i.next();
			assertEquals("Third", s);
		}
		assertEquals("Third", dq.removeFirst());
		assertEquals(3, dq.size());
		assertFalse(dq.isEmpty());
		i = dq.iterator();
		if (i.hasNext()) {
			String s = i.next();
			assertEquals("First", s);
		}
		assertEquals("Four", dq.removeLast());
		assertEquals(2, dq.size());
		assertFalse(dq.isEmpty());
		i = dq.iterator();
		if (i.hasNext()) {
			String s = i.next();
			assertEquals("First", s);
		}
		assertEquals("First", dq.removeFirst());
		assertEquals(1, dq.size());
		assertFalse(dq.isEmpty());
		i = dq.iterator();
		if (i.hasNext()) {
			String s = i.next();
			assertEquals("Second", s);
		}
		assertEquals("Second", dq.removeFirst());
		assertEquals(0, dq.size());
		assertTrue(dq.isEmpty());
	}
}
