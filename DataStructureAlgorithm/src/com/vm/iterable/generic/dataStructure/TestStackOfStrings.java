package com.vm.iterable.generic.dataStructure;

import edu.princeton.cs.algs4.StdOut;

public class TestStackOfStrings {

	public TestStackOfStrings() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		for (int i = 0; i < args.length; i++) {
			String input = args[i];
			if (input.equals("-")) {
				StdOut.println(s.pop());
			} else {
				s.push(input);
			}
		}

		Stack<Integer> s1 = new Stack<Integer>();
		s1.push(10);
		s1.push(20);
		s1.push(30);
		s1.push(40);
		s1.push(50);
		s1.push(60);
		StdOut.println(s1.pop());
		StdOut.println(s1.pop());
		StdOut.println(s1.pop());
		StdOut.println(s1.pop());
		StdOut.println(s1.pop());
		StdOut.println(s1.pop());
		
		
		
		for(String str: s){
			System.out.println(str);
		}
		
		for(Integer str: s1){
			System.out.println(str);
		}
	}
}
