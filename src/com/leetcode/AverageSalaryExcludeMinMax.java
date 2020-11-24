/*
author: hezhigang
date: 11/24/20
time: 6:16 AM
*/
package com.leetcode;

import java.util.Arrays;

/**
 * 1491. Average Salary Excluding the Minimum and Maximum Salary
 * https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 */
public class AverageSalaryExcludeMinMax {

    /**
     * linearithmic
     * 43 / 43 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Average Salary Excluding the Minimum and Maximum Salary.
     * Memory Usage: 36.7 MB, less than 75.02% of Java online submissions for Average Salary Excluding the Minimum and Maximum Salary.
     * @param salary
     * @return
     */
    public static double average_v1(int[] salary) {
        final int N = salary.length;
        Arrays.sort(salary);
        double t = salary[1];
        for (int i = 2; i < N - 1; i++) {
            t += salary[i];
        }
        return t / (N - 2);
    }

    /**
     * linear
     * 43 / 43 test cases passed.
     * 0 ms, faster than 100.00% of Java online submissions for Average Salary Excluding the Minimum and Maximum Salary.
     * 37.1 MB, less than 11.62% of Java online submissions for Average Salary Excluding the Minimum and Maximum Salary.
     * @param salary
     * @return
     */
    public static double average(int[] salary) {
        final int N = salary.length;
        int min = salary[0], max = salary[0];
        double sum = salary[0];
        for (int i = 1; i < N; i++) {
            if (salary[i] < min) min = salary[i];
            if (salary[i] > max) max = salary[i];
            sum += salary[i];
        }
        sum = sum - max - min;
        return sum / (N - 2);
    }

    public static void main(String[] args) {
//        int[] salary = {4000, 3000, 1000, 2000};
//        int[] salary = {1000, 2000, 3000};
//        int[] salary = {6000, 5000, 4000, 3000, 2000, 1000};
        int[] salary = {8000, 9000, 2000, 3000, 6000, 1000};
        double average = average(salary);
        System.out.printf("the average salary of employees excluding the minimum and maximum salary = %f", average);
    }
}
