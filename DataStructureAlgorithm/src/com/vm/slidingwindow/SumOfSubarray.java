package com.vm.slidingwindow;

/**
 * Given an array of length n find the sum of all the subarray of size k
 * 
 * @author Venkatesh Manohar
 *
 */
public class SumOfSubarray {

	public void sumOfSubArray(int[] nums, int k) {
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if ((i+1) >= k) {
				if ((i - k) >= 0) {
					sum -= nums[(i - k)];
				}

				System.out.println("Sum untill i:" + i + " =" + sum);
			}
		}
	}

	public static void main(String[] args) {
		SumOfSubarray sos = new SumOfSubarray();
		sos.sumOfSubArray(new int[] { 1, 3, 4, 2, 6, 3 }, 3);
	}
}
