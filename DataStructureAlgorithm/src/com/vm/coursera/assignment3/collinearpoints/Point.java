package com.vm.coursera.assignment3.collinearpoints;

/******************************************************************************
 *  Compilation:  javac Point.java
 *  Execution:    java Point
 *  Dependencies: none
 *  
 *  An immutable data type for points in the plane.
 *  For use on Coursera, Algorithms Part I programming assignment.
 *
 ******************************************************************************/

import java.util.Comparator;

import edu.princeton.cs.algs4.StdDraw;

/**
 * Represents point in a two dimensional space.
 * 
 * @author Venkatesh Manohar
 *
 */
public class Point implements Comparable<Point> {
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
    /**
     * x-coordinate of this point.
     */
    private final int x;
    /**
     * y-coordinate of this point.
     */
    private final int y;
    
    /**
     * Initializes a new point.
     *
     * @param x
     *            the <em>x</em>-coordinate of the point
     * @param y
     *            the <em>y</em>-coordinate of the point
     */
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    /**
     * Draws this point to standard draw.
     */
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    /**
     * Draws the line segment between this point and the specified point to
     * standard draw.
     *
     * @param that
     *            the other point
     */
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    /**
     * Returns the slope between this point and the specified point. Formally,
     * if the two points are (x0, y0) and (x1, y1), then the slope is (y1 - y0)
     * / (x1 - x0). For completeness, the slope is defined to be +0.0 if the
     * line segment connecting the two points is horizontal;
     * Double.POSITIVE_INFINITY if the line segment is vertical; and
     * Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1) are equal.
     *
     * @param that
     *            the other point
     * @return the slope between this point and the specified point
     */
    public double slopeTo(final Point that) {
        if (that.x == this.x) {
            if (this.y == that.y) {
                return Double.NEGATIVE_INFINITY;
            }
            return Double.POSITIVE_INFINITY;
        }

        if (this.y == that.y) {
            return 0.0;
        }

        double yval = that.y - this.y;
        double xval = that.x - this.x;
        return yval / xval;
    }

    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate.
     * Formally, the invoking point (x0, y0) is less than the argument point
     * (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     *
     * @param that
     *            the other point
     * @return the value <tt>0</tt> if this point is equal to the argument point
     *         (x0 = x1 and y0 = y1); a negative integer if this point is less
     *         than the argument point; and a positive integer if this point is
     *         greater than the argument point
     */
    public int compareTo(final Point that) {
        if (this.y < that.y) {
            return LESSER;
        } else if (this.y == that.y && this.x < that.x) {
            return LESSER;
        } else if (this.x == that.x && this.y == that.y) {
            return EQUAL;
        } else {
            return GREATER;
        }
    }

    /**
     * Compares two points by the slope they make with this point. The slope is
     * defined as in the slopeTo() method.
     *
     * @return the Comparator that defines this ordering on points
     */
    public Comparator<Point> slopeOrder() {
        return new SlopeOrder();
    }

    /**
     * Returns a string representation of this point. This method is provide for
     * debugging; your program should not rely on the format of the string
     * representation.
     *
     * @return a string representation of this point
     */
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    /**
     * Comparator that compares its two argument points by the slopes they make
     * with the invoking point (x0, y0). Formally, the point (x1, y1) is less
     * than the point (x2, y2) if and only if the slope (y1 - y0) / (x1 - x0) is
     * less than the slope (y2 - y0) / (x2 - x0). Treat horizontal, vertical,
     * and degenerate line segments as in the slopeTo() method.
     * 
     * @author Venkatesh Manohar
     *
     */
    private class SlopeOrder implements Comparator<Point> {

        @Override
        public int compare(Point p1, Point p2) {
            double slopeToP1 = slopeTo(p1);
            double slopeToP2 = slopeTo(p2);

            if (slopeToP1 < slopeToP2) {
                return LESSER;
            } else if (slopeToP1 > slopeToP2) {
                return GREATER;
            } else {
                return EQUAL;
            }
        }

    }

    /**
     * Unit tests the Point data type.
     */
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}