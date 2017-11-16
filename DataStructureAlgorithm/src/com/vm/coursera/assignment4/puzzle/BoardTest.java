package com.vm.coursera.assignment4.puzzle;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

public class BoardTest {

    @Test
    public void TestBoardConstructor() {
        int[][] temp = { { 0, 1 }, { 2, 3 } };
        Board b = new Board(temp);
        assertEquals(b.dimension(), 2);
        assertEquals(b.hamming(), 3);
        assertEquals(b.manhattan(), 4);
        assertFalse(b.isGoal());
        Board twin = b.twin();
        assertFalse(b.equals(twin));
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestNullBoardConstructor() {
        int[][] temp = null;
        Board b = new Board(temp);
    }

    @Test
    public void TestBoard3x3Constructor() {
        int[][] temp = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
        Board b = new Board(temp);
        assertEquals(b.dimension(), 3);
        assertEquals(b.hamming(), 8);
        assertEquals(b.manhattan(), 12);
        assertFalse(b.isGoal());
        Board twin = b.twin();
        assertFalse(b.equals(twin));
        Board twin2 = twin.twin();
        assertFalse(twin.equals(twin2));
        Board twin3 = twin2.twin();
        assertFalse(twin3.equals(twin2));
    }

    @Test
    public void TestBoardInPlace() {
        int[][] temp = { { 1, 2 }, { 3, 0 } };
        Board b = new Board(temp);
        assertEquals(b.dimension(), 2);
        assertEquals(b.hamming(), 0);
        assertEquals(b.manhattan(), 0);
        assertTrue(b.isGoal());
        Board twin = b.twin();
        assertFalse(b.equals(twin));
    }

    @Test
    public void TestBoard3x3InPlace() {
        int[][] temp = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
        Board b = new Board(temp);
        assertEquals(b.dimension(), 3);
        assertEquals(b.hamming(), 0);
        assertEquals(b.manhattan(), 0);
        assertTrue(b.isGoal());
        Board twin = b.twin();
        assertFalse(b.equals(twin));
    }

    @Test
    public void TestBoardNeighbors() {
        int[][] temp = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
        Board b = new Board(temp);
        assertEquals(b.dimension(), 3);
        assertEquals(b.hamming(), 0);
        assertEquals(b.manhattan(), 0);
        assertTrue(b.isGoal());
        Board twin = b.twin();
        assertFalse(b.equals(twin));
        Iterable<Board> neighbors = b.neighbors();
        int countNeighbors = 0;
        Iterator<Board> it = neighbors.iterator();
        while (it.hasNext()) {
            Board neighbor = it.next();
            if (!b.equals(neighbor)) {
                countNeighbors++;
            }
        }
        assertEquals(countNeighbors, 2);
    }

    @Test
    public void TestBoardNeighborsAll4() {
        int[][] temp = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 5 } };
        Board b = new Board(temp);
        assertEquals(b.dimension(), 3);
        assertEquals(b.hamming(), 1);
        assertEquals(b.manhattan(), 2);
        assertFalse(b.isGoal());
        Board twin = b.twin();
        assertFalse(b.equals(twin));
        Iterable<Board> neighbors = b.neighbors();
        int countNeighbors = 0;
        Iterator<Board> it = neighbors.iterator();
        while (it.hasNext()) {
            Board neighbor = it.next();
            if (!b.equals(neighbor)) {
                countNeighbors++;
            }
        }
        assertEquals(countNeighbors, 4);
    }

    @Test
    public void TestTwin() {
        int[][] temp = { { 0, 3, 1 }, { 2, 5, 4 }, { 8, 6, 7 } };
        Board b = new Board(temp);
        Board twin = b.twin();
        assertFalse(b.equals(twin));
    }

    @Test
    public void TestUnequalBoards() {
        int[][] twox2 = {{3,0},{1,2}};
        int[][] threex3 = {{3, 0, 6}, {2, 1, 7 },{ 4,  8,  5 }};
        
        Board a = new Board(twox2);
        Board b = new Board(threex3);
        assertFalse(a.equals(b));
        assertFalse(b.equals(a));
        assertTrue(a.equals(a));
        assertTrue(b.equals(b));
    }
    
    @Test
    public void TestHammingForPuzzle27(){
        int[][] test = {{5 ,8 ,7} ,{1 ,4 ,6} ,{3 ,0 ,2}};
        Board b = new Board(test);
        assertEquals(b.hamming(), 7);
    }
    
    @Test
    public void TestHammingForPuzzle00s13neighbor(){
        int[][] test = {{1,2,3,4,5,6,7,8,9,10 },{
            11,12,13,14,15,16,17,18,19,20},{
                21,22,23,24,25,26,27,28,29,30},{
                31,32,33,34,35,36,37,38,39,40},{
                41,42,43,44,45,46,47,48,49,50},{
                51,52,53,54,55,56,57,58,59,60},{
                61,62,63,64,65,66,67,68,69,70},{
                71,72,0,74,75,76,77,78,79,80},{
                81,82,73,84,85,86,87,88,89,90},{
                91,92,83,93,94,95,96,97,98,99}};
        Board b = new Board(test);
        assertEquals(b.hamming(), 9);
    }
    @Test
    public void TestManhattan(){
        int[][] threex3 = {{5, 8, 7}, {1, 4, 6 },{ 0,  3,  2 }};
        Board b = new Board(threex3);
        assertEquals(b.manhattan(), 16);
    }
    
}
