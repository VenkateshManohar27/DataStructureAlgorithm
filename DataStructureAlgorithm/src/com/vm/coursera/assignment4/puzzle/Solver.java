package com.vm.coursera.assignment4.puzzle;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
    private class Move implements Comparable<Move> {
        /**
         * Used by Comparators to return -1 indicating value is less.
         */
        private static final int LESSER = -1;
        /**
         * Used by Comparators to return 1 indicating value is greater.
         */
        private static final int GREATER = 1;
        /**
         * Used by Comparators to return 1 indicating value is equal.
         */
        private static final int EQUAL = 0;

        Board board;
        int moves = 0;
        Move predecessor = null;
        int cachedPriority = -1;

        public Move(Board board) {
            this.board = board;
        }

        public Move(Board board, Move predecessor) {
            super();
            this.board = board;
            this.moves = predecessor.moves + 1;
            this.predecessor = predecessor;
        }

        private int priority() {
            if (cachedPriority == -1) {
                cachedPriority = this.board.manhattan() + this.moves;
            }
            return cachedPriority;
        }

        @Override
        public int compareTo(Move move) {
            if (this.priority() < move.priority()) {
                return LESSER;
            } else if (this.priority() > move.priority()) {
                return GREATER;
            }
            return EQUAL;
        }

    }

    // private MinPQ<Move> boardStates = new MinPQ<>();
    private Move lastMove = null;

    private Stack<Board> solutionStates;

    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException("Board cannot be null");
        }

        Move initialMove = new Move(initial);
        MinPQ<Move> boardStates = new MinPQ<>();
        boardStates.insert(initialMove);

        Move twin = new Move(initial.twin());
        MinPQ<Move> twinStates = new MinPQ<>();
        twinStates.insert(twin);
        while (true) {
            lastMove = solve(boardStates);
            if (lastMove != null || solve(twinStates) != null)
                return;
        }
    }

    private Move solve(MinPQ<Move> brdStates) {
        if (brdStates.isEmpty()) {
            return null;
        }
        Move predecessor = brdStates.delMin();
        if (predecessor.board.isGoal()) {
            return predecessor;
        }

        for (Board state : predecessor.board.neighbors()) {
            if (isDuplicate(predecessor, state)) {
                continue;
            }
            Move move = new Move(state, predecessor);
            brdStates.insert(move);
        }
        return null;

    }

    private boolean isDuplicate(Move predecessor, Board current) {
        while (predecessor != null) {
            if (predecessor.board.equals(current)) {
                return true;
            }
            predecessor = predecessor.predecessor;
        }
        return false;
    }

    public boolean isSolvable() {
        return (lastMove != null);
    }

    public int moves() {
        return (lastMove != null) ? lastMove.moves : -1;
    }

    public Iterable<Board> solution() {
        if (!isSolvable()) {
            return null;
        } else if (solutionStates == null) {
            solutionStates = new Stack<>();
            solutionStates.push(lastMove.board);
            while (lastMove.predecessor != null) {
                lastMove = lastMove.predecessor;
                solutionStates.push(lastMove.board);
            }
        }
        return solutionStates;
    }

    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

}
