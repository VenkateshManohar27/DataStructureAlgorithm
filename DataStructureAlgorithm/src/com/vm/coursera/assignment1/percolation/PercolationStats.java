package com.vm.coursera.assignment1.percolation;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * 
 * @author Venkatesh Manohar
 *
 */
public class PercolationStats {
	/**
	 * Constant for confidence calculations.
	 */
	private static final double CONSTANT = 1.96;
	/**
	 * Count of experiments.
	 */
	private final int experimentsCount;

	/**
	 * Fractions array for storing results of all executions.
	 */
	private final double[] fractions;

	/**
	 * Performs T independent computational experiments on an N-by-N grid.
	 * 
	 * @param n
	 *            - Number n.
	 * @param t
	 *            - Number of executions
	 */
	public PercolationStats(final int n, final int t) {
		if (n <= 0 || t <= 0) {
			throw new IllegalArgumentException("Given N <= 0 || T <= 0");
		}
		experimentsCount = t;
		fractions = new double[experimentsCount];
		for (int expNum = 0; expNum < experimentsCount; expNum++) {
			Percolation pr = new Percolation(n);
			int openedSites = 0;
			while (!pr.percolates()) {
				int i = StdRandom.uniform(1, n + 1);
				int j = StdRandom.uniform(1, n + 1);
				if (!pr.isOpen(i, j)) {
					pr.open(i, j);
					openedSites++;
				}
			}
			double fraction = (double) openedSites / (n * n);
			fractions[expNum] = fraction;
		}
	}

	/**
	 * Sample mean of percolation threshold.
	 * 
	 * @return mean of executions.
	 */
	public double mean() {
		return StdStats.mean(fractions);
	}

	/**
	 * Sample standard deviation of percolation threshold.
	 * 
	 * @return deviation of executions.
	 */
	public double stddev() {
		return StdStats.stddev(fractions);
	}

	/**
	 * 
	 * @return Returns lower bound of the 95% confidence interval.
	 */
	public double confidenceLo() {
		return mean() - ((CONSTANT * stddev()) / Math.sqrt(experimentsCount));
	}

	/**
	 * @return Returns upper bound of the 95% confidence interval.
	 */
	public double confidenceHi() {
		return mean() + ((CONSTANT * stddev()) / Math.sqrt(experimentsCount));
	}

	/**
	 * 
	 * @param args
	 *            - arguments
	 */
	public static void main(final String[] args) {
		int n = Integer.parseInt(args[0]);
		int t = Integer.parseInt(args[1]);
		PercolationStats ps = new PercolationStats(n, t);

		String confidence = ps.confidenceLo() + ", " + ps.confidenceHi();
		StdOut.println("mean                    = " + ps.mean());
		StdOut.println("stddev                  = " + ps.stddev());
		StdOut.println("95% confidence interval = " + confidence);
	}
}
