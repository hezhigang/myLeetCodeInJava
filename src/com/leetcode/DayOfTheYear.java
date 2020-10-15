/*
author: hezhigang
date: 10/15/20
time: 2:05 PM
*/
package com.leetcode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

/**
 * 1154. Day of the Year
 * https://leetcode.com/problems/day-of-the-year/
 */
public class DayOfTheYear {

    /**
     * java8 LocalDate
     * Runtime: 16 ms, faster than 6.07% of Java online submissions for Day of the Year.
     * Memory Usage: 38.3 MB, less than 7.64% of Java online submissions for Day of the Year.
     * @param date
     * @return
     */
    public static int dayOfYear_jdk(String date) {
        LocalDate d = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return d.getDayOfYear();
    }

    /**
     * https://astronomy.stackexchange.com/questions/2407/calculate-day-of-the-year-for-a-given-date
     * @param date
     * @return
     */
    public static int dayOfYear_wrong(String date) {
        StringTokenizer tokenizer = new StringTokenizer(date,"-", false);
        int year = Integer.parseInt(tokenizer.nextToken());
        int month = Integer.parseInt(tokenizer.nextToken());
        int day = Integer.parseInt(tokenizer.nextToken());
        int N1 = new Double(Math.floor(275 * month / 9)).intValue();
        int N2 = new Double(Math.floor((month + 9) / 12)).intValue();
        int N3 = 1 + new Double(Math.floor((year - 4 * Math.floor(year / 4) + 2) / 3)).intValue();
        int N = N1 - (N2 * N3) + day - 30;
        return N;
    }

    public static int dayOfYear_v1(String date) {
        StringTokenizer tokenizer = new StringTokenizer(date, "-", false);
        int year = Integer.parseInt(tokenizer.nextToken());
        int month = Integer.parseInt(tokenizer.nextToken());
        int day = Integer.parseInt(tokenizer.nextToken());
        int[] dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean leapYear = false;
        if (year % 4 != 0)
            ;
        else if (year % 25 != 0)
            leapYear = true;
        else if (year % 16 != 0)
            ;
        else
            leapYear = true;
        if (leapYear)
            dayOfMonth[1] = 29;
        int dy = day;
        for (int i = 1; i < month; i++) {
            dy += dayOfMonth[i - 1];
        }
        return dy;
    }

    /**
     * https://www.tutorialspoint.com/Java-program-to-find-if-the-given-number-is-a-leap-year
     * @param date
     * @return
     */
    public static int dayOfYear(String date) {
        StringTokenizer tokenizer = new StringTokenizer(date, "-", false);
        int year = Integer.parseInt(tokenizer.nextToken());
        int month = Integer.parseInt(tokenizer.nextToken());
        int day = Integer.parseInt(tokenizer.nextToken());
        int[] dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean leapYear = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
        if (leapYear)
            dayOfMonth[1] = 29;
        int dy = day;
        for (int i = 1; i < month; i++) {
            dy += dayOfMonth[i - 1];
        }
        return dy;
    }

    public static void main(String[] args) {
//        String date = "2019-01-09";
//        String date = "2019-02-10";
//        String date = "2003-03-01";
//        String date = "2004-03-01";
//        String date = "1900-03-25";
        String date = "2016-02-29";
        System.out.printf("day %s of the year is : %d", date, dayOfYear(date));
    }
}
