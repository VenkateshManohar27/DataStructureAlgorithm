package com.vm.coursera.assignment4.puzzle;
import java.util.LinkedList;

public class Board {
    private static final int BLANK_BLOCK = 0;
    private final int dimension;
    private final int[][] tiles;
    private final int hamming;
    private final int manhattan;
    private boolean goal = false;
    private Iterable<Board> neighbors = null;
    /**
     * construct a board from an n-by-n array of blocks.
     * 
     * @param blocks
     */
    public Board(int[][] blocks) {
        super();
        if (blocks == null) {
            throw new IllegalArgumentException(" Block board canot be null");
        }
        this.dimension = blocks.length;
        //this.tiles = copy(blocks);
        this.tiles = blocks;
        this.hamming = calculateHamming();
        this.manhattan = calculateManhattan();
        this.goal = checkIfGoal();
    }

    private int[][] copy(int[][] src) {
        int[][] target = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                target[i][j] = src[i][j];
            }
        }
        return target;
    }

    private int calculateHamming() {
        int countMisplaced = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                int index = blockIndex(i, j);
                if (!isBlank(i, j) && !inPlace(index, tiles[i][j])) {
                    countMisplaced++;
                }
            }
        }
        return countMisplaced;
    }

    private int calculateManhattan() {
        int manhattanDistanceSum = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                int value = tiles[i][j]; // tiles array contains board elements
                if (value != 0) { // we don't compute MD for element 0
                    int targetX = (value - 1) / this.dimension;
                    int targetY = (value - 1) % this.dimension;
                    int dx = i - targetX; // x-distance to expected coordinate
                    int dy = j - targetY; // y-distance to expected coordinate
                    manhattanDistanceSum += Math.abs(dx) + Math.abs(dy);
                }
            }
        }
        return manhattanDistanceSum;
    }

    /**
     * board dimension n.
     * 
     * @return
     */
    public int dimension() {
        return dimension;
    }

    public int hamming() {
        return hamming;
    }

    private boolean inPlace(int blockIndex, int value) {
        return blockIndex == value;
    }

    private int blockIndex(int row, int col) {
        return (row * dimension) + col + 1;
    }

    public int manhattan() {
        return manhattan;
    }
    
    private boolean checkIfGoal(){
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (!isBlank(i, j) && !inPlace(blockIndex(i, j), tiles[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isGoal() {
        return goal;
    }

    private boolean isBlank(int row, int col) {
        return tiles[row][col] == BLANK_BLOCK;
    }

    public Board twin() {
        /* int[][] clone = copy(tiles); */
        Board twin = new Board(copy(tiles));
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension - 1; j++) {
                if (!isBlank(i, j) && !isBlank(i, j + 1)) {
                    swap(twin.tiles, i, j, i, j + 1);
                    return twin;
                }
            }
        }
        return twin;
    }

    private void swap(int[][] arr, int row1, int col1, int row2, int col2) {
        int temp = arr[row1][col1];
        arr[row1][col1] = arr[row2][col2];
        arr[row2][col2] = temp;
    }

    public boolean equals(Object y) {
        if (y == this) {
            return true;
        }

        if (!(y instanceof Board)) {
            return false;
        }
        
        Board temp = (Board) y;
        if(temp.tiles.length != dimension || temp.tiles[0].length != dimension){
            return false;
        }
        
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (tiles[i][j] != temp.tiles[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public Iterable<Board> neighbors() {
        if(this.neighbors != null){
            return this.neighbors;
        }
        LinkedList<Board> neighborList = new LinkedList<>();
        int[] blankLocation = findBlankLocation();
        int blankRowIndex = blankLocation[0];
        int blankColIndex = blankLocation[1];

        if (hasLeftNeighbor(blankColIndex)) {
            //Board swappedLeftNeighbour = new Board(tiles);
            int [][] leftNeighbourSwappedBlock = copy(tiles);
            swap(leftNeighbourSwappedBlock, blankRowIndex, blankColIndex - 1,
                    blankRowIndex, blankColIndex);
            Board swappedLeftNeighbour = new Board(leftNeighbourSwappedBlock);
            neighborList.add(swappedLeftNeighbour);
        }

        if (hasRightNeighbor(blankColIndex)) {
            //Board swappedRightNeighbour = new Board(tiles);
            int [][] rightNeighbourSwappedBlock = copy(tiles);
            swap(rightNeighbourSwappedBlock, blankRowIndex, blankColIndex + 1,
                    blankRowIndex, blankColIndex);
            Board swappedRightNeighbour = new Board(rightNeighbourSwappedBlock);
            neighborList.add(swappedRightNeighbour);
        }

        if (hasTopNeighbor(blankRowIndex)) {
            //Board swappedTopNeighbour = new Board(tiles);
            int [][] topNeighbourSwappedBlock = copy(tiles);
            swap(topNeighbourSwappedBlock, blankRowIndex - 1, blankColIndex,
                    blankRowIndex, blankColIndex);
            Board swappedTopNeighbour = new Board(topNeighbourSwappedBlock);
            neighborList.add(swappedTopNeighbour);
        }

        if (hasBottomNeighbor(blankRowIndex)) {
            //Board swappedBottomNeighbour = new Board(tiles);
            int [][] bottomNeighbourSwappedBlock = copy(tiles);
            swap(bottomNeighbourSwappedBlock, blankRowIndex + 1, blankColIndex,
                    blankRowIndex, blankColIndex);
            Board swappedBottomNeighbour = new Board(bottomNeighbourSwappedBlock);
            neighborList.add(swappedBottomNeighbour);
        }
        this.neighbors = neighborList;
        return neighborList;
    }

    private int[] findBlankLocation() {
        int[] blankLocation = new int[2];
        boolean blankFound = false;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                blankFound = isBlank(i, j);
                if (blankFound) {
                    blankLocation[0] = i;
                    blankLocation[1] = j;
                }
            }
            if (blankFound) {
                break;
            }
        }
        return blankLocation;
    }

    private boolean hasLeftNeighbor(int col) {
        return col > 0;
    }

    private boolean hasRightNeighbor(int col) {
        return col < dimension - 1;
    }

    private boolean hasTopNeighbor(int row) {
        return row > 0;
    }

    private boolean hasBottomNeighbor(int row) {
        return row < dimension - 1;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(dimension + "\n");
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                s.append(String.format("%2d ", tiles[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

}
