package com.vm.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private boolean grid[][];
	private int size = 0;
	private WeightedQuickUnionUF wQUF;
	private int top = 0;
	private int bottom;

	public Percolation(int n) {
		// create n-by-n grid, with all sites blocked
		if (n <= 0) {
			throw new IllegalArgumentException();
		}
		size = n;
		wQUF = new WeightedQuickUnionUF(size * size + 2);
		/*
		 * top = new int[size]; for (int index = 0; index< top.length; index++){
		 * top[index]=index; }
		 */
		bottom = size * size + 1;
		/*
		 * new int[size]; int bottomIndex= (size*size)-size; for (int index =0;
		 * index< bottom.length; index++){ bottom[index]=bottomIndex;
		 * bottomIndex++; }
		 */
		grid = new boolean[size][size];

	}

	public void open(int row, int col) {
		// open site (row, col) if it is not open already
		if (row < 0 || row > size || col < 0 || col > size) {
			throw new IndexOutOfBoundsException();
		}
		if (!grid[row - 1][col - 1]) {
			grid[row - 1][col - 1] = true;
			if (row == 1) {
				wQUF.union(getQFIndex(row, col), top);
			}
			if (row == size) {
				wQUF.union(getQFIndex(row, col), bottom);
			}
			if (col > 1 && isOpen(row, col - 1)) {
				wQUF.union(getQFIndex(row, col), getQFIndex(row, col - 1));
			}
			if (col < size && isOpen(row, col + 1)) {
				wQUF.union(getQFIndex(row, col), getQFIndex(row, col + 1));
			}
			if (row > 1 && isOpen(row - 1, col)) {
				wQUF.union(getQFIndex(row, col), getQFIndex(row - 1, col));
			}
			if (row < size && isOpen(row + 1, col)) {
				wQUF.union(getQFIndex(row, col), getQFIndex(row + 1, col));
			}
		}

	}

	public boolean isOpen(int row, int col) { // is site (row, col) open?{
		if (row < 0 || row > size || col < 0 || col > size) {
			throw new IndexOutOfBoundsException();
		}

		return grid[row - 1][col - 1];
	}

	public boolean isFull(int row, int col) {
		// is site (row, col) full?
		if (row < 0 || row > size || col < 0 || col > size) {
			throw new IndexOutOfBoundsException();
		}

		return wQUF.connected(top, getQFIndex(row, col));

	}

	public boolean percolates() {
		// does the system percolate?

		return wQUF.connected(top, bottom);
	}

	private int getQFIndex(int row, int col) {
		return size * (row - 1) + col;
	}

	/*public void print() {
		System.out.println("*******************************************************************");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(grid[i][j] + " |");
			}
			System.out.println();
		}
		System.out.println("*******************************************************************");

	}*/

	public static void main(String[] args) {
		// test client (optional)
		Percolation p = new Percolation(3);
		//p.print();

		p.open(0, 1);
		p.open(1, 1);
		p.open(2, 1);
		p.open(2, 2);

		//p.print();

	}
}
