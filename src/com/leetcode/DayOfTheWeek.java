package com.leetcode;

import java.time.LocalDate;

/**
 * 1185. Day of the Week
 * https://leetcode.com/problems/day-of-the-week/
 */
public class DayOfTheWeek {

    /**
     * Doomsday Algorithm : (d+m+y+[y/4]+c ) mod 7
     * https://www.hackerearth.com/blog/developers/how-to-find-the-day-of-a-week/
     * @param day
     * @param month
     * @param year
     * @return
     */
    public static String dayOfTheWeek(int day, int month, int year) {
        String s = "";
        int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        if (month < 3) year -= 1;
        int i = (year + year/4 - year/100 + year/400 + t[month-1] + day) % 7;
        switch (i) {
            case 1: s = "Monday"; break;
            case 2: s = "Tuesday"; break;
            case 3: s = "Wednesday"; break;
            case 4: s = "Thursday"; break;
            case 5: s = "Friday"; break;
            case 6: s = "Saturday"; break;
            case 0: case 7: s = "Sunday"; break;
            default: ;
        }

        return s;
    }

    /**
     * jdk
     * @param day
     * @param month
     * @param year
     * @return
     */
    public static String dayOfTheWeek_jdk8(int day, int month, int year) {
        String s = "";
        LocalDate d = LocalDate.of(year, month, day);
        switch (d.getDayOfWeek().getValue()) {
            case 1: s = "Monday"; break;
            case 2: s = "Tuesday"; break;
            case 3: s = "Wednesday"; break;
            case 4: s = "Thursday"; break;
            case 5: s = "Friday"; break;
            case 6: s = "Saturday"; break;
            case 7: s = "Sunday"; break;
            default: ;
        }
        return s;
    }

    public static void main(String[] args) {
//        int day = 31, month = 8, year = 2019;
//        int day = 18, month = 7, year = 1999;
        int day = 15, month = 8, year = 1993;

        System.out.printf("%d-%02d-%d is %s, by JDK", year, month, day, dayOfTheWeek_jdk8(day, month, year));
        System.out.println();
        System.out.printf("%d-%02d-%d is %s, by Doomsday Algorithm", year, month, day, dayOfTheWeek(day, month, year));
    }
}
