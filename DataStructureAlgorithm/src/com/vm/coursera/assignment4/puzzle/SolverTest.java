package com.vm.coursera.assignment4.puzzle;
import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class SolverTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void testNullBoard(){
        Board b = null;
        Solver s = new Solver(b);
    }

    @Test
    public void testSolverPuzzle00() {
        int[][] test = { { 1, 0 }, { 3, 2 } };
        Board b = new Board(test);
        Solver s = new Solver(b);
        assertTrue(s.isSolvable());
        assertEquals(s.moves(), 1);
    }

    @Test
    public void testUnsolveable() {
        int[][] test = { { 1, 0 }, { 2, 3 } };
        Board b = new Board(test);
        Solver s = new Solver(b);
        assertFalse(s.isSolvable());
        assertEquals(s.moves(), -1);
    }

    @Test
    public void TestPuzzle14() {
        int[][] test = { { 1, 2, 3, 4, 5, 7, 14 }, { 8, 9, 10, 11, 12, 13, 6 },
                { 15, 16, 17, 18, 19, 20, 21 }, { 22, 23, 24, 25, 26, 27, 28 },
                { 29, 30, 31, 32, 0, 33, 34 }, { 36, 37, 38, 39, 40, 41, 35 },
                { 43, 44, 45, 46, 47, 48, 42 } };
        Board b = new Board(test);
        Solver s = new Solver(b);
        assertTrue(s.isSolvable());
        assertEquals(s.moves(), 14);
    }

    @Test
    public void TestPuzzle02() {
        int[][] test = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 10, 11, 12, 13, 14, 15, 16, 17, 18 },
                { 19, 20, 21, 22, 23, 24, 25, 26, 27 },
                { 28, 29, 30, 31, 32, 33, 34, 35, 36 },
                { 37, 38, 39, 40, 41, 42, 43, 44, 45 },
                { 46, 47, 48, 49, 50, 51, 52, 53, 54 },
                { 55, 56, 57, 58, 59, 60, 61, 62, 63 },
                { 64, 65, 66, 67, 68, 69, 70, 0, 71 },
                { 73, 74, 75, 76, 77, 78, 79, 80, 72 } };
        Board b = new Board(test);
        Solver s = new Solver(b);
        assertTrue(s.isSolvable());
        assertEquals(s.moves(), 2);
    }

    @Test
    public void TestSolution() {
        int[][] test = { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 },
                { 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 },
                { 41, 42, 43, 44, 45, 46, 47, 48, 49, 50 },
                { 51, 52, 53, 54, 55, 56, 57, 58, 59, 60 },
                { 61, 62, 63, 64, 65, 66, 67, 68, 69, 70 },
                { 71, 72, 73, 74, 75, 76, 77, 78, 79, 80 },
                { 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 },
                { 91, 92, 93, 94, 95, 96, 97, 98, 99, 0 } };
        Board b = new Board(test);
        Solver s = new Solver(b);
        assertTrue(s.isSolvable());
        assertEquals(s.moves(), 0);
        Iterable<Board> collection = s.solution();
        Iterator<Board> it = collection.iterator();
        assertTrue(it.hasNext());
    }

    @Test
    public void TestSolutionPuzzle02() {
        int[][] test = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 10, 11, 12, 13, 14, 15, 16, 17, 18 },
                { 19, 20, 21, 22, 23, 24, 25, 26, 27 },
                { 28, 29, 30, 31, 32, 33, 34, 35, 36 },
                { 37, 38, 39, 40, 41, 42, 43, 44, 45 },
                { 46, 47, 48, 49, 50, 51, 52, 53, 54 },
                { 55, 56, 57, 58, 59, 60, 61, 62, 63 },
                { 64, 65, 66, 67, 68, 69, 70, 0, 71 },
                { 73, 74, 75, 76, 77, 78, 79, 80, 72 } };

        Board b = new Board(test);
        Solver s = new Solver(b);
        assertTrue(s.isSolvable());
        assertEquals(s.moves(), 2);
        Iterable<Board> collection = s.solution();
        Iterator<Board> it = collection.iterator();
        int i = 0;
        while (++i <= 3) {
            assertTrue(it.hasNext());
            it.next();
        }
    }

}
