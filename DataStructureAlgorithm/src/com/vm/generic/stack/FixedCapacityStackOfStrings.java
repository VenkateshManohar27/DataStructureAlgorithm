package com.vm.generic.stack;

import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfStrings<T> {
	private T[] s = null;
	private int N = 0;

	@SuppressWarnings("unchecked")
	public FixedCapacityStackOfStrings(int size) {
		s = (T[])new Object[size];

	}

	public boolean isEmpty() {
		return (N == 0);
	}

	public T pop() {
		return s[--N];
	}

	public void push(T item) {
		s[N++] = item;
	}

	public static void main(String[] args) {
		FixedCapacityStackOfStrings<String> s = new FixedCapacityStackOfStrings<String>(10);
		for (int i = 0; i < args.length; i++) {
			String input = args[i];
			if (input.equals("-")) {
				StdOut.println(s.pop());
			} else if (!input.equals(" ")) {
				s.push(input);
			}
		}
	}

}
