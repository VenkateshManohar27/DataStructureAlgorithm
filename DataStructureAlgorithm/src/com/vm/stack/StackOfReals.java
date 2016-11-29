package com.vm.stack;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class StackOfReals implements Iterable<Double> {
	private Node first = null;

	private class Node {
		Double item;
		Node next;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public Double pop() {
		Double item = first.item;
		first = first.next;
		return item;
	}

	public void push(Double input) {
		// TODO Auto-generated method stub
		Node oldFirst = first;
		first = new Node();
		first.item = input;
		first.next = oldFirst;

	}

	public double max() {
		double max = 0;
		for (Double d : this) {
			if (d > max) {
				max = d;

			}
		}
		return max;
	}

	@Override
	public Iterator<Double> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Double> {
		private Node current = first;

		@Override
		public boolean hasNext() {

			return current != null;
		}

		@Override
		public Double next() {
			Double item = current.item;
			current = current.next;
			return item;
		}

	}
	
	public static void main(String[] args) {
		

		StackOfReals s1 = new StackOfReals();
		s1.push( 10.0);
		s1.push(20.0);
		s1.push(30.0);
		s1.push(40.0);
		s1.push(50.0);
		s1.push(60.0);
		System.out.println(s1.max());
		StdOut.println(s1.pop());
		StdOut.println(s1.pop());
		StdOut.println(s1.pop());
		StdOut.println(s1.pop());
		StdOut.println(s1.pop());
		StdOut.println(s1.pop());
		
		
		
		
		
	}
}
