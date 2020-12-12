/*
author: hezhigang
date: 12/11/20
time: 8:00 PM
*/
package com.leetcode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * 1360. Number of Days Between Two Dates
 * https://leetcode.com/problems/number-of-days-between-two-dates/
 */
public class DaysBetweenDates {

    final static int[] daysUpToMonth = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
    final static int[] daysUpToMonthLeapYear = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }

    /**
     * jdk
     * 105 / 105 test cases passed.
     * Runtime: 14 ms, faster than 13.23% of Java online submissions for Number of Days Between Two Dates.
     * Memory Usage: 38.4 MB, less than 21.16% of Java online submissions for Number of Days Between Two Dates.
     * @param date1
     * @param date2
     * @return
     */
    public static int daysBetweenDates_jdk(String date1, String date2) {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate d1 = LocalDate.parse(date1, dft);
        LocalDate d2 = LocalDate.parse(date2, dft);
        long diff = DAYS.between(d1, d2);
        int d = new Long(diff).intValue();
        return d >= 0 ? d : -d;
    }

    /**
     * 4. Origin-based Algorithm
     * http://www.sunshine2k.de/articles/coding/datediffindays/calcdiffofdatesindates.html
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static int GetDaysOffsetFromOrigin(int year, int month, int day) {
        if (isLeapYear(year)) {
            year--;
            int numOfLeapsYear = year / 4 - year / 100 + year / 400;
            return year * 365 + numOfLeapsYear + daysUpToMonthLeapYear[month - 1] + day - 1;
        } else {
            year--;
            int numOfLeapsYear = year / 4 - year / 100 + year / 400;
            return year * 365 + numOfLeapsYear + daysUpToMonth[month - 1] + day - 1;
        }
    }

    /**
     * 105 / 105 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Days Between Two Dates.
     * Memory Usage: 37.1 MB, less than 71.69% of Java online submissions for Number of Days Between Two Dates.
     * @param date1
     * @param date2
     * @return
     */
    public static int daysBetweenDates(String date1, String date2) {
        int y1 = Integer.parseInt(date1.substring(0, 4));
        int m1 = Integer.parseInt(date1.substring(5, 7));
        int d1 = Integer.parseInt(date1.substring(8, 10));

        int y2 = Integer.parseInt(date2.substring(0, 4));
        int m2 = Integer.parseInt(date2.substring(5, 7));
        int d2 = Integer.parseInt(date2.substring(8, 10));

        int daysOffset = GetDaysOffsetFromOrigin(y1, m1, d1);
        int daysOffset2 = GetDaysOffsetFromOrigin(y2, m2, d2);

        int diff = daysOffset2 - daysOffset;

        return diff >= 0 ? diff : -diff;
    }

    public static void main(String[] args) {
//        String date1 = "2019-06-29", date2 = "2019-06-30";
        String date1 = "2020-01-15", date2 = "2019-12-31";
        int d = daysBetweenDates(date1, date2);
        System.out.printf("There are %d days between %s and %s", d, date1, date2);
    }
}
