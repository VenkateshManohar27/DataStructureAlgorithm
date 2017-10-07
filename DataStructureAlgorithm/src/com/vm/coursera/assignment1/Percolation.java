package com.vm.coursera.assignment1;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * 
 * @author Venkatesh Manohar
 *
 */
public class Percolation {
	/**
	 * Grid representing n-by-n sites.
	 */
	private boolean[][] grid;
	/**
	 * WeightedQuickUnionUF instance.
	 */
	private final WeightedQuickUnionUF weightedQuickUnionUF;
	/**
	 * virtualTop site which is connected to top row in constructor.
	 */
	private final int virtualTop;
	/**
	 * virtualBottom site which is connected to bottom row in constructor.
	 */
	private final int virtualBottom;
	/**
	 * number represents n.
	 */
	private final int number;
	
	/**
	 * counter to hold number of openSites.
	 */
	private int numberOfOpenSites = 0;

	/**
	 * Creates n-by-n grid, with all sites blocked,Creates a weighted quick
	 * union find instance with number + 2 sites. Virtual bottom index is
	 * initialized
	 * 
	 * @param num
	 *            size n f grid
	 */
	public Percolation(final int num) {
		if (num <= 0) {
			throw new IllegalArgumentException(
					"Number can't be less than or equal to zero.");
		}
		number = num;
		grid = new boolean[num][num];
		weightedQuickUnionUF = new WeightedQuickUnionUF((num * num) + 2);
		virtualTop = 0;
		virtualBottom = (num * num) + 1;
	}

	/**
	 * The open() method does three things. First, it should validate the
	 * indices of the site that it receives. Second, it marks the site as open.
	 * Third, it performs sequence of WeightedQuickUnionUF operations that links
	 * the site in question to its open neighbors. The constructor and instance
	 * variables should facilitate the open() method's ability to do its job.
	 * 
	 * @param row
	 *            Input row
	 * @param col
	 *            Input Column
	 */
	public void open(final int row, final int col) {
		int actualRow = getActualIndex(row);
		int actualCol = getActualIndex(col);
		boolean opened = openSite(actualRow, actualCol);
		if (opened) {
			this.numberOfOpenSites++;
			connectNeighbors(row, col, actualRow, actualCol);
		}
	}

	/**
	 * Connects all the open neighbors to newly open site.
	 * 
	 * @param inputRow
	 *            - User provided row
	 * @param inputColumn
	 *            - User provided column
	 * @param actualRow
	 *            - mapped row
	 * @param actualColumn
	 *            - mapped column
	 */
	private void connectNeighbors(final int inputRow, final int inputColumn,
			final int actualRow, final int actualColumn) {
		connectVirtualTop(actualRow, actualColumn);
		connectLeftNeighbor(inputRow, inputColumn, actualRow, actualColumn);
		connectRightNeighbor(inputRow, inputColumn, actualRow, actualColumn);
		connectTopNeighbor(inputRow, inputColumn, actualRow, actualColumn);
		connectBottomNeighbor(inputRow, inputColumn, actualRow, actualColumn);
		connectVirtualBottom(inputRow, inputColumn, actualRow, actualColumn);
	}

	/**
	 * Connects newly open site to virtual bottom if it belongs to last row.
	 * 
	 * @param actualRow
	 *            - mapped row
	 * @param actualColumn
	 *            - mapped column
	 */
	private void connectVirtualBottom(final int inputRow, final int inputColumn,
			final int actualRow, final int actualColumn) {
		int lastrow = number;
		if (isFull(inputRow, inputColumn) && isFull(lastrow, inputColumn)) {
			int mappedIndex = this.map2DCoordinatesTo1D(actualRow,
					actualColumn);
			weightedQuickUnionUF.union(this.virtualBottom, mappedIndex);
		}

	}

	/**
	 * Connects newly open site to virtual Top if it belongs to top row.
	 * 
	 * @param actualRow
	 *            - mapped row
	 * @param actualColumn
	 *            - mapped column
	 */
	private void connectVirtualTop(final int actualRow,
			final int actualColumn) {
		if (actualRow == 0) {
			int mappedIndex = this.map2DCoordinatesTo1D(actualRow,
					actualColumn);
			weightedQuickUnionUF.union(this.virtualTop, mappedIndex);
		}
	}

	/**
	 * Connects the left neighbor to newly open site.
	 * 
	 * @param inputRow
	 *            - User provided row
	 * @param inputColumn
	 *            - User provided column
	 * @param actualRow
	 *            - mapped row
	 * @param actualColumn
	 *            - mapped column
	 */
	private void connectLeftNeighbor(final int inputRow, final int inputColumn,
			final int actualRow, final int actualColumn) {
		if (actualColumn > 0) {
			int mappedIndex = this.map2DCoordinatesTo1D(actualRow,
					actualColumn);
			boolean isLeftNeighbourOpen = this.isOpen(inputRow,
					inputColumn - 1);
			if (isLeftNeighbourOpen) {
				int leftNeighbourMappedIndex = this
						.map2DCoordinatesTo1D(actualRow, actualColumn - 1);
				this.weightedQuickUnionUF.union(mappedIndex,
						leftNeighbourMappedIndex);
			}
		}
	}

	/**
	 * Connects the Right neighbor to newly open site.
	 * 
	 * @param inputRow
	 *            - User provided row
	 * @param inputColumn
	 *            - User provided column
	 * @param actualRow
	 *            - mapped row
	 * @param actualColumn
	 *            - mapped column
	 */
	private void connectRightNeighbor(final int inputRow, final int inputColumn,
			final int actualRow, final int actualColumn) {
		if (actualColumn <= number - 2) {
			int mappedIndex = this.map2DCoordinatesTo1D(actualRow,
					actualColumn);
			boolean isRightNeighbourOpen = this.isOpen(inputRow,
					inputColumn + 1);
			if (isRightNeighbourOpen) {
				int rightNeighbourMappedIndex = this
						.map2DCoordinatesTo1D(actualRow, actualColumn + 1);
				this.weightedQuickUnionUF.union(mappedIndex,
						rightNeighbourMappedIndex);
			}
		}
	}

	/**
	 * Connects the Bottom neighbor to newly open site.
	 * 
	 * @param inputRow
	 *            - User provided row
	 * @param inputColumn
	 *            - User provided column
	 * @param actualRow
	 *            - mapped row
	 * @param actualColumn
	 *            - mapped column
	 */
	private void connectBottomNeighbor(final int inputRow,
			final int inputColumn, final int actualRow,
			final int actualColumn) {
		if (actualRow <= number - 2) {
			int mappedIndex = this.map2DCoordinatesTo1D(actualRow,
					actualColumn);
			boolean isBottomNeighbourOpen = this.isOpen(inputRow + 1,
					inputColumn);
			if (isBottomNeighbourOpen) {
				int bottomNeighbourMappedIndex = this
						.map2DCoordinatesTo1D(actualRow + 1, actualColumn);
				this.weightedQuickUnionUF.union(mappedIndex,
						bottomNeighbourMappedIndex);
			}
		}
	}

	/**
	 * Connects the Top neighbor to newly open site.
	 * 
	 * @param inputRow
	 *            - User provided row
	 * @param inputColumn
	 *            - User provided column
	 * @param actualRow
	 *            - mapped row
	 * @param actualColumn
	 *            - mapped column
	 */
	private void connectTopNeighbor(final int inputRow, final int inputColumn,
			final int actualRow, final int actualColumn) {
		if (actualRow > 0) {
			int mappedIndex = this.map2DCoordinatesTo1D(actualRow,
					actualColumn);
			boolean isTopNeighbourOpen = this.isOpen(inputRow - 1, inputColumn);
			if (isTopNeighbourOpen) {
				int topNeighbourMappedIndex = this
						.map2DCoordinatesTo1D(actualRow - 1, actualColumn);
				this.weightedQuickUnionUF.union(mappedIndex,
						topNeighbourMappedIndex);
			}
		}
	}

	/**
	 * Opens a site.
	 * 
	 * @param row
	 *            - mapped row
	 * @param col
	 *            - mapped col
	 * @return boolean indicating whether site is opened or not
	 */
	private boolean openSite(final int row, final int col) {
		if (!grid[row][col]) {
			grid[row][col] = true;
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param row
	 *            index
	 * @param col
	 *            index
	 * @return boolean indicating whether site is open
	 */
	public boolean isOpen(final int row, final int col) {
		int actualRow = getActualIndex(row);
		int actualCol = getActualIndex(col);
		return grid[actualRow][actualCol];
	}

	/**
	 * A full site is an open site that can be connected to an open site in the
	 * top row via a chain of neighboring (left, right, up, down) open sites.
	 * 
	 * @param row
	 *            - User provided row
	 * @param col
	 *            - User provided col
	 * @return boolean
	 */
	public boolean isFull(final int row, final int col) {

		if (!isOpen(row, col)) {
			return false;
		}
		int actualRow = getActualIndex(row);
		int actualCol = getActualIndex(col);
		int mappedIndex = map2DCoordinatesTo1D(actualRow, actualCol);
		return this.weightedQuickUnionUF.connected(mappedIndex,
				this.virtualTop);
	}

	/**
	 * 
	 * @return Number of open sites at any given moment
	 */
	public int numberOfOpenSites() {
		return this.numberOfOpenSites;
	}

	/**
	 * We say the system percolates if there is a full site in the bottom row.
	 * In other words, a system percolates if we fill all open sites connected
	 * to the top row and that process fills some open site on the bottom row.
	 * 
	 * @return true if virtualtop and bottom are connected
	 */
	public boolean percolates() {
		return this.weightedQuickUnionUF.connected(virtualTop, virtualBottom);
	}

	/**
	 * 
	 * @param index
	 *            index
	 * @return integer index
	 */
	private int getActualIndex(final int index) {
		if (index <= 0 || index > number) {
			throw new IllegalArgumentException("Invalid Index");
		}
		return index - 1;
	}

	/**
	 * 
	 * @param row
	 *            - actual row index of grid
	 * @param column
	 *            - actual column index of grid
	 * @return integer
	 */
	private int map2DCoordinatesTo1D(final int row, final int column) {
		return (row * number + column) + 1;
	}
}
