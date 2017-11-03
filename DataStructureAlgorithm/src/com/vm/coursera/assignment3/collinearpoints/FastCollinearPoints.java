package com.vm.coursera.assignment3.collinearpoints;
import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPoints {
    /**
     * List of lineSegments which represents the endpoints of collinear points.
     */
    private ArrayList<LineSegment> list = new ArrayList<>();

    public FastCollinearPoints(Point[] points) {
        // check corner cases
        if (points == null) {
            throw new NullPointerException();
        }
        Point[] pointsCopy = points.clone();
        Arrays.sort(pointsCopy);

        checkNullOrDuplicates(pointsCopy);
        // and now show must go on )))

        for (int i = 0; i < pointsCopy.length - 3; i++) {
            Arrays.sort(pointsCopy);

            // Sort the points according to the slopes they makes with p.
            // Check if any 3 (or more) adjacent points in the sorted order
            // have equal slopes with respect to p. If so, these points,
            // together with p, are collinear.

            Arrays.sort(pointsCopy, pointsCopy[i].slopeOrder());

            for (int p = 0, first = 1, last = 2; last < pointsCopy.length; last++) {
                // find last collinear to p point
                while (last < pointsCopy.length && Double.compare(
                        pointsCopy[p].slopeTo(pointsCopy[first]),
                        pointsCopy[p].slopeTo(pointsCopy[last])) == 0) {
                    last++;
                }
                // if found at least 3 elements, make segment if it's unique
                if (last - first >= 3
                        && pointsCopy[p].compareTo(pointsCopy[first]) < 0) {
                    list.add(new LineSegment(pointsCopy[p],
                            pointsCopy[last - 1]));
                }
                // Try to find next
                first = last;
            }
        }
        // finds all line segments containing 4 or more points
    }

    // the number of line segments
    public int numberOfSegments() {
        return list.size();
    }

    // the line segments
    public LineSegment[] segments() {
        return list.toArray(new LineSegment[list.size()]);
    }

    /**
     * Checks for duplicate entry in the sorted array.
     * 
     * @param pointsArr
     *            -sorted points array.
     */
    private void checkNullOrDuplicates(final Point[] pointsArr) {
        for (int i = 0; i < pointsArr.length - 1; i++) {
            if (pointsArr[i] == null || pointsArr[i + 1] == null
                    || pointsArr[i].compareTo(pointsArr[i + 1]) == 0) {
                throw new IllegalArgumentException(
                        "Points array has duplicate entries or null entries");
            }
        }

    }

    public static void main(String[] args) {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

}