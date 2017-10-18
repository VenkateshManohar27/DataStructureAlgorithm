package com.vm.comparator;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class DateTimeTest {
    /**
     * Dates are in format DDMMYYYY.
     */
    private DateTime date111970, date27091984, date17102017, today, tomorrow,
            sixtyDaysAhead;

    @Before
    public void initialization() {
        date111970 = new DateTime(1, 1, 1970);
        date27091984 = new DateTime(27, 9, 1984);
        date17102017 = new DateTime(17, 10, 2017);
        Calendar calendar = Calendar.getInstance();
        today = new DateTime(calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));

        calendar.add(Calendar.DAY_OF_YEAR, 1);

        tomorrow = new DateTime(calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));

        calendar.add(Calendar.DAY_OF_YEAR, 60);

        sixtyDaysAhead = new DateTime(calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));

    }

    @Test
    public void testDatesAreLesser() {
        assertEquals(DateTime.LESSER, date111970.compareTo(today));
        assertEquals(DateTime.LESSER, date27091984.compareTo(today));
        assertEquals(DateTime.LESSER, date17102017.compareTo(today));
    }
    
    @Test
    public void testDatesAreGreater() {
        assertEquals(DateTime.GREATER, today.compareTo(date27091984));
        assertEquals(DateTime.GREATER, tomorrow.compareTo(date111970));
        assertEquals(DateTime.GREATER, sixtyDaysAhead.compareTo(date17102017));
    }

    @Test
    public void testDatesAreEqual() {
        assertEquals(DateTime.EQUAL, date111970.compareTo(date111970));
        assertEquals(DateTime.EQUAL, date27091984.compareTo(date27091984));
        assertEquals(DateTime.EQUAL, date17102017.compareTo(date17102017));
        assertEquals(DateTime.EQUAL, today.compareTo(today));
        assertEquals(DateTime.EQUAL, tomorrow.compareTo(tomorrow));
        assertEquals(DateTime.EQUAL, sixtyDaysAhead.compareTo(sixtyDaysAhead));
    }


}
