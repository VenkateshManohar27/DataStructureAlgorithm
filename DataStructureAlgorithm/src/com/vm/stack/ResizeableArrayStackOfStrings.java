package com.vm.stack;

import edu.princeton.cs.algs4.StdOut;

public class ResizeableArrayStackOfStrings {
	private String[] s = new String[1];
	private int N = 0;

	

	public boolean isEmpty() {
		return (N == 0);
	}
	
	public String pop(){
		String result = s[--N];
		s[N]= null;
		if((N>0 && N == s.length/4)) resize(s.length/2);
		return result;
	}
	
	public void push(String item){
		if(N == s.length)resize(2*s.length);
		s[N++]=item;
	}
	
	public void resize(int size){
		System.out.println("Resized +++++++++");
		 
		String[] old = s;
		s = new String[size];
		for(int i=0;i< N; i++){
			s[i]=old[i];
		}
		
	}
	
	public static void main(String[] args) {
		ResizeableArrayStackOfStrings s = new ResizeableArrayStackOfStrings();
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
