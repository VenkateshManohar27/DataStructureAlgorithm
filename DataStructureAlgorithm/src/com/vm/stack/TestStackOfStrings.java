package com.vm.stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestStackOfStrings {

	public TestStackOfStrings() {
		// TODO Auto-generated constructor stub
	}

	/*public static void main(String[] args) {
		StackOfStrings s = new StackOfStrings();
		while (!StdIn.isEmpty()) {
			String input = StdIn.readString();
			if(input.equals("-")){
				StdOut.print(s.pop());
			}else{
				s.push(input);
			}
		}
	}*/
	public static void main(String[] args) {
		StackOfStrings s = new StackOfStrings();
		for(int i=0;i < args.length; i++){
			String input = args[i];
			if(input.equals("-")){
				StdOut.println(s.pop());
			}else{
				s.push(input);
			}
		}
	}
}
