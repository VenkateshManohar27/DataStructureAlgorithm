package com.vm.generic.stack;

public class StackOfStrings<T> {

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

}
