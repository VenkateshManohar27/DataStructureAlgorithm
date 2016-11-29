package com.vm.progassign2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] q;
	private int n = 0;
	private int size = 0;

	public RandomizedQueue() {
		q = (Item[]) new Object[1];
		size = 1;
	}

	public void enqueue(Item item) {
		if (n + 1 == size)
			resize(size * 2);
		q[n++] = item;
	}

	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("queue is empty");
		}
		int i = StdRandom.uniform(n);
		Item item = q[i];
		q[i] = q[n--];
		q[n] = null;
		if (n < size / 4)
			resize(size / 2);
		return item;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		// return the number of items on the queue
		return size;
	}

	public Item sample() {
		if (isEmpty()) {
			throw new NoSuchElementException("queue is empty");
		}
		int i = StdRandom.uniform(n);
		Item item = q[i];
		return item;
	}

	private void resize(int newsize) {
		this.size = newsize;
		Item[] old = q;
		q = (Item[]) new Object[this.size];
		for (int i = 0; i < n; i++) {
			q[i] = old[i];
		}

	}

	public Iterator<Item> iterator() {
		return new RandomizedQIterator();
	}

	private class RandomizedQIterator implements Iterator<Item> {
		private int current = 0;
		private int[] shuffledIndexes = new int[n];

		public boolean hasNext() {
			if (current == 0) {
				for (int i = 0; i < n; i++)
					shuffledIndexes[i] = i;
				StdRandom.shuffle(shuffledIndexes);
			}
			return current < n;
		}

		public Item next() {
			if (current == 0) {
				for (int i = 0; i < n; i++)
					shuffledIndexes[i] = i;
				StdRandom.shuffle(shuffledIndexes);
			}
			if (current >= n || size() == 0)
				throw new java.util.NoSuchElementException();
			return q[shuffledIndexes[current++]];
		}

		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}
	}

	public static void main(String[] args) {
		RandomizedQueue<String> rQ = new RandomizedQueue<String>();
		rQ.enqueue("1");
		rQ.enqueue("2");
		rQ.enqueue("3");
		rQ.enqueue("4");
		for (String str : rQ) {
			StdOut.println(str);
		}
		StdOut.println("############################################");
		StdOut.println(rQ.dequeue());
		for (String str : rQ) {
			StdOut.println(str);
		}
		StdOut.println("############################################");
		rQ.dequeue();
		rQ.dequeue();
		rQ.dequeue();
		for (String str : rQ) {
			StdOut.println(str);
		}
		StdOut.println("############################################");
		for (String str : rQ) {
			StdOut.println(str);
		}
	}
}
