package com.vm.interview.questions;

import com.vm.iterable.generic.dataStructure.Stack;

import edu.princeton.cs.algs4.StdOut;

public class QueueWithStacks <T>{
	
	Stack<T> stack1 = new Stack<T>();
	Stack<T> stack2 = new Stack<T>();
	
	public void enqueue(T item) {
		stack1.push(item);
	}

	public T dequeue() {
		
		if(isEmpty()){
			return null;
		}
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		
		
		return stack2.pop();
		
	}

	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

	public static void main(String[] args) {
		QueueWithStacks<String> s = new QueueWithStacks<String>();
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
