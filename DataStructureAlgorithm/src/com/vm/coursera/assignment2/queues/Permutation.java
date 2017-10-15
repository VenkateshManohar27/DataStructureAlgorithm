package com.vm.coursera.assignment2.queues;
import edu.princeton.cs.algs4.StdIn;

/**
 * Permutation.java that takes an integer k as a command-line argument; reads in
 * a sequence of strings from standard input using StdIn.readString(); and
 * prints exactly k of them, uniformly at random. Print each item from the
 * sequence at most once.
 * 
 * @author Venkatesh Manohar
 *
 */
public class Permutation {
    /**
     * 
     * 
     * @param args
     *            Command line arguments
     */
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            rq.enqueue(StdIn.readString());
        }
        for (int i = 0; i < k; i++) {
            System.out.println(rq.dequeue());
        }

    }
}
