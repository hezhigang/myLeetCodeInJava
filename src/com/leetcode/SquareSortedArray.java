package com.leetcode;

import java.util.Arrays;

/**
 * 977. Squares of a Sorted Array
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class SquareSortedArray {

    public static int[] sortedSquares_v1(int[] A) {
        int tmp = 0;
        for (int i = 0; i < A.length; i++) {
            tmp = A[i];
            A[i] = tmp * tmp;
        }
        Arrays.sort(A);
        return A;
    }

    public static int[] sortedSquares(int[] A) {
        final int N = A.length;
        int tmp = 0;
        int k = 0;
        for (int i = 0; i < A.length; i++) {
            tmp = A[i];
            if (tmp < 0) {
                k = i;
            }
            A[i] = tmp * tmp;
        }
        System.out.println(k);
        return A;
    }

    public static void main(String[] args) {
//        int[] nums = { -4, -1, 0, 3, 10 };
//        int[] nums = { -7, -3, 2, 3, 11 };
        int[] nums = { -8, -1, 0, 3, 5 };
        System.out.printf("Input: %s\n\r", Arrays.toString(nums));
        int[] A = sortedSquares(nums);
        System.out.printf("Output: %s\n\r", Arrays.toString(A));
    }
}