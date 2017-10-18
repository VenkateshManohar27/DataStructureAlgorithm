package com.vm.comparator;

/**
 * The Date time class is a simple class implemented to understand the
 * implementation of comparable object.
 * 
 * @author Venkatesh Manohar
 *
 */
public class DateTime implements Comparable<DateTime> {
    /**
     * Day of month starting from 1.
     */
    private final int day;
    /**
     * Month of the year starting at 1. i.e 1 is Jan, 2 is Feb etc.
     */
    private final int month;
    /**
     * Year as int.
     */
    private final int year;
    
    public static final int LESSER = -1;
    public static final int GREATER = 1;
    public static final int EQUAL = 0;
    
    /**
     * 
     * @param day of the month
     * @param month of the year
     * @param year year.
     */
    public DateTime(final int day, final int month, final int year) {
        super();
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * @param that
     *            is the data object which is compared with this instance.
     * @return boolean indicating whether the date object is lesser, greater or
     *         equal to object passed as arguments.
     */
    @Override
    public final int compareTo(final DateTime that) {
        if (this.year > that.year) {
            return GREATER;
        } else if (this.year < that.year) {
            return LESSER;
        } else if (this.month > that.month) {
            return GREATER;
        } else if (this.month < that.month) {
            return LESSER;
        } else if (this.day > that.day) {
            return GREATER;
        } else if (this.day < that.day) {
            return LESSER;
        }
        return EQUAL;
    }

}
