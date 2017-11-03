package com.vm.coursera.assignment3.collinearpoints;
import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {

    /**
     * List of lineSegments which represents the endpoints of collinear points.
     */
    private ArrayList<LineSegment> list = new ArrayList<>();

    /**
     * finds all line segments containing 4 points.
     * 
     * @param points
     */
    public BruteCollinearPoints(Point[] points) {
        super();
        if (points == null) {
            throw new IllegalArgumentException("Points array cannot be null");
        }

        Point[] pointsCopy = points.clone();
        Arrays.sort(pointsCopy);
        checkNullOrDuplicates(pointsCopy);

        for (int i = 0; i < pointsCopy.length - 3; i++) {
            for (int j = i + 1; j < pointsCopy.length - 2; j++) {
                double slopeIJ = pointsCopy[i].slopeTo(pointsCopy[j]);
                for (int k = j + 1; k < pointsCopy.length - 1; k++) {
                    double slopeJK = pointsCopy[j].slopeTo(pointsCopy[k]);
                    double slopeIK = pointsCopy[i].slopeTo(pointsCopy[j]);
                    if (Double.compare(slopeIJ, slopeJK) == 0
                            && Double.compare(slopeIJ, slopeIK) == 0) {

                        for (int m = k + 1; m < pointsCopy.length; m++) {
                            double slopeIL = pointsCopy[i]
                                    .slopeTo(pointsCopy[m]);
                            if (Double.compare(slopeIJ, slopeIL) == 0) {
                                LineSegment ls = new LineSegment(pointsCopy[i],
                                        pointsCopy[m]);
                                list.add(ls);
                            }
                        }
                    }
                }
            }
        }
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

    /**
     * The number of line segments.
     * 
     * @return
     */
    public int numberOfSegments() {
        return list.size();
    }

    /**
     * The line segments.
     * 
     * @return
     */
    public LineSegment[] segments() {
        return list.toArray(new LineSegment[list.size()]);
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
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {

            StdOut.println(segment);
            segment.draw();

        }
        StdDraw.show();
    }

}
