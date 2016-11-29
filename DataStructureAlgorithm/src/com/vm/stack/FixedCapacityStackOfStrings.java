package com.vm.stack;

import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfStrings {
	private String[] s = null;
	private int N = 0;

	public FixedCapacityStackOfStrings(int size) {
		s = new String[size];

	}

	public boolean isEmpty() {
		return (N == 0);
	}
	
	public String pop(){
		return s[--N];
	}
	
	public void push(String item){
		s[N++]=item;
	}
	
	public static void main(String[] args) {
		FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(10);
		for(int i=0;i < args.length; i++){
			String input = args[i];
			if(input.equals("-")){
				StdOut.println(s.pop());
			}else if(!input.equals(" ")){
				s.push(input);
			}
		}
	}

}
