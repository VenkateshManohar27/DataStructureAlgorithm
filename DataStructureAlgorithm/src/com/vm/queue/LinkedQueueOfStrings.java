package com.vm.queue;

import edu.princeton.cs.algs4.StdOut;

public class LinkedQueueOfStrings {
	private Node first = null;
	private Node last = null;

	private class Node {
		String item;
		Node next;
	}

	public void enqueue(String item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}

	}

	public String dequeue() {

		String item = first.item;
		first = first.next;
		if (isEmpty()) {
			last = null;
		}
		return item;
	}

	public boolean isEmpty() {
		return first == null;
	}

	
	public static void main(String[] args) {
		LinkedQueueOfStrings s = new LinkedQueueOfStrings();
		for(int i=0;i < args.length; i++){
			String input = args[i];
			if(input.equals("-")){
				StdOut.println(s.dequeue());
			}else if(!input.equals(" ")){
				s.enqueue(input);
			}
		}
	}

}
