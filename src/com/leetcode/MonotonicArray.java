/*
author: hezhigang
date: 10/18/20
time: 10:34 PM
*/
package com.leetcode;

import java.util.Arrays;

/**
 * 896. Monotonic Array
 * https://leetcode.com/problems/monotonic-array/
 */
public class MonotonicArray {

    /**
     * 366 / 366 test cases passed.
     * Runtime: 2 ms, faster than 31.40% of Java online submissions for Monotonic Array.
     * Memory Usage: 46.9 MB, less than 18.59% of Java online submissions for Monotonic Array.
     * @param A
     * @return
     */
    public static boolean isMonotonic_my(int[] A) {
        final int N = A.length;
        if (N <= 2)
            return true;
        int[] d = new int[N - 1];
        for (int i = 1, j = 0; i < N; i++, j++) {
            d[j] = A[i] - A[i - 1];
        }
        int min = d[0], max = d[0];
        for (int i = 0; i < N - 1; i++) {
            if (d[i] < min) min = d[i];
            if (d[i] > max) max = d[i];
        }
        return (min <= 0 && max <= 0) || (min >= 0 && max >= 0);
    }

    /**
     * One Pass
     * https://leetcode.com/problems/monotonic-array/solution/
     * @param A
     * @return
     */
    public static boolean isMonotonic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) decreasing = false;
            if (A[i] < A[i + 1]) increasing = false;
        }
        return increasing || decreasing;
    }

    public static void main(String[] args) {
//        int[] A = {1, 2, 2, 3};
//        int[] A = {6, 5, 4, 4};
//        int[] A = {1, 3, 2};
//        int[] A = {1, 2, 4, 5};
//        int[] A = {1, 1, 1};
//        int[] A = {2, 2, 2, 1, 4, 5};
        int[] A = {11, 11, 9, 4, 3, 3, 3, 1, -1, -1, 3, 3, 3, 5, 5, 5};
        boolean b = isMonotonic(A);
        System.out.printf("%s %s monotonic", Arrays.toString(A), b ? "is" : "is not");
    }
}
