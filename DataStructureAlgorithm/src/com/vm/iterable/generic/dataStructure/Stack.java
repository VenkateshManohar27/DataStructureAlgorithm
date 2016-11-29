package com.vm.iterable.generic.dataStructure;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

	private Node first = null;

	private class Node {
		T item;
		Node next;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public T pop() {
		
		T item = first.item;
		first = first.next;
		return item;
	}

	public void push(T input) {
		// TODO Auto-generated method stub
		Node oldFirst = first;
		first = new Node();
		first.item = input;
		first.next = oldFirst;

	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}

	private class ListIterator implements Iterator<T>{
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			
			return current != null;
		}

		@Override
		public T next() {
			T item = current.item;
			current = current.next;
			return item;
		}
		
	}
}
