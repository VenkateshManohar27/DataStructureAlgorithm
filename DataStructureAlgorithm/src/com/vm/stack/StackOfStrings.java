package com.vm.stack;

public class StackOfStrings {

	private Node first = null;
	
	private class Node{
		String item;
		Node next;
	}
	
	public boolean isEmpty(){
		return (first == null);
	}
	
	public String pop() {
		String item = first.item;
		first = first.next;		
		return item;
	}

	public void push(String input) {
		// TODO Auto-generated method stub
		Node oldFirst = first;
		first = new Node();
		first.item = input;
		first.next= oldFirst;
				
	}

}
