package com.vm.utility;

/**
 * http://www.geeksforgeeks.org/next-power-of-2/
 */
public class NextPowerOf2 {

	public static int nextPowerOf2(int num) {
		if (num == 0) {
			return 1;
		}
		if (num > 0 && (num & (num - 1)) == 0) {
			return num;
		}
		while ((num & (num - 1)) > 0) {
			num = num & (num - 1);
		}
		return num << 1;
	}

	public static void main(String args[]) {
		System.out.println(NextPowerOf2.nextPowerOf2(4));
	}
}
