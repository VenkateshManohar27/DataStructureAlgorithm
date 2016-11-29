package com.vm.notworking;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Node first = null;
	private Node last = null;
	private int N = 0;

	public RandomizedQueue() {
		// construct an empty randomized queue
	}

	private class Node {
		Item item;
		Node next;
	}

	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
		N++;

	}

	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("queue is empty");
		}
		/*
		 * int random = (int) Math.ceil((Math.random() * N)); int current = 0;
		 * Node node = first ; Node prev = first; Item item = null; while
		 * (current < random){
		 * 
		 * prev = node; node = node.next;
		 * 
		 * current ++; } item = node.item; prev.next = node.next;
		 */
		Item item = null;
		Node node = first ;
		int random =(int) Math.floor((Math.random() * N));
		for (int i = 0; i < N; i++) {
			item = node.item;
			
			if(i == random){
				node.next = node.next.next;	
				
				break;
			}
		}

		N--;
		return item;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		// return the number of items on the queue
		return N;
	}

	public Item sample() {
		if (isEmpty()) {
			throw new NoSuchElementException("queue is empty");
		}
		int random = (int) Math.floor(Math.random() * N);
		int current = 0;
		Node node = first;
		while (current < random) {
			current++;
			node = node.next;
		}
		Item item = node.item;
		node = null;
		return item;
	}

	public Iterator<Item> iterator() {
		return new RandomizedQIterator();
	}

	private class RandomizedQIterator implements Iterator<Item> {
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
