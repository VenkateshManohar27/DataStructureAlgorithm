package com.vm.utility;

public class PerformanceLogging {
	
	public static long start() {
		return System.currentTimeMillis();
	}
	
	public static long stop(long startTime) {
		return System.currentTimeMillis() - startTime;
	}

}
