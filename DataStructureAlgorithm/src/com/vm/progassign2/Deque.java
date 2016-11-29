package com.vm.progassign2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	private Node first = null;
	private Node last = null;

	private int size = 0;

	private class Node {
		Item item = null;
		Node next = null;
		Node prev = null;
	}

	public Deque() {
		// construct an empty deque

	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return size;
	}

	public void addFirst(Item item) {
		if (item == null) {
			throw new NullPointerException("Item is empty");
		}
		Node newNode = new Node();
		newNode.item = item;
		if (isEmpty()) {
			first = newNode;
			last = first;

		} else {
			newNode.next = first;
			first.prev = newNode;
			first = newNode;
		}

		size++;
	}

	public void addLast(Item item) {
		if (item == null) {
			throw new NullPointerException("Item is empty");
		}
		Node newNode = new Node();
		newNode.item = item;
		if (isEmpty()) {
			last = newNode;
			first = last;

		} else {

			last.next = newNode;
			newNode.prev = last;
			last = newNode;
		}

		size++;
	}

	public Item removeFirst() {
		// remove and return the item from the front
		if (isEmpty()) {
			throw new NoSuchElementException("queue is empty");
		}
		Item item = first.item;
		first = first.next;

		if (first == null) {
			last = null;
		} else {
			first.prev = null;
		}

		size--;

		return item;
	}

	public Item removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("queue is empty");
		}

		Item item = last.item;
		last = last.prev;

		if (last == null) {
			first = null;
		} else {
			last.next = null;
		}

		size--;
		return item;
	}

	public Iterator<Item> iterator() {
		return new QIterator();
	}

	private class QIterator implements Iterator<Item> {
		private Node current = first;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Item next() {
			if (current == null) {
				throw new NoSuchElementException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	public static void main(String[] args) {
		// unit testing
		Deque<String> s = new Deque<String>();
		s.addFirst("1");
		s.addFirst("2");
		s.addLast("3");
		s.addLast("4");
		for (String str : s) {
			System.out.println(str);
		}
		System.out.println("SIZE: " + s.size);

		s.removeFirst();
		s.removeLast();
		for (String str : s) {
			System.out.println(str);
		}
		System.out.println("SIZE: " + s.size);
		System.out.println("#############################################################");
		s.removeFirst();
		s.removeFirst();

	}
}