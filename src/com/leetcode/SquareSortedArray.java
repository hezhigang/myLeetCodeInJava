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

    public static int[] sortedSquares_v2(int[] A) {
        final int N = A.length;
        if (A[0] >= 0) {
            int tmp = 0;
            for (int i = 0; i < N; i++) {
                tmp = A[i];
                A[i] = tmp * tmp;
            }
            return A;
        } else if (A[N - 1] <= 0) {
            int[] r = new int[N];
            for (int i = 0; i < N; i++) {
                r[i] = A[N - 1 - i] * A[N - 1 - i];
            }
            return r;
        } else {
            int[] r = new int[N];
            int left = 0, right = 0;
            int k = N - 1;
            for (int i = 0, j = N - 1; i <= j; ) {
                left = A[i] * A[i];
                right = A[j] * A[j];
                if (left < right) {
                    j--;
                    r[k--] = right;
                } else {
                    i++;
                    r[k--] = left;
                }
            }
            return r;
        }
    }

    public static int[] sortedSquares(int[] A) {
        final int N = A.length;
        int[] r = new int[N];
        int left = 0, right = 0;
        int k = N - 1;
        for (int i = 0, j = N - 1; i <= j; ) {
            left = A[i] * A[i];
            right = A[j] * A[j];
            if (left < right) {
                j--;
                r[k--] = right;
            } else {
                i++;
                r[k--] = left;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = { -4, -1, 0, 3, 10 };
//        int[] nums = { -7, -3, 2, 3, 11 };
//        int[] nums = { -8, -1, 0, 3, 5 };
//        int[] nums = { -2, 0 };
        System.out.printf("Input: %s\n\r", Arrays.toString(nums));
        int[] A = sortedSquares(nums);
        System.out.printf("Output: %s\n\r", Arrays.toString(A));
    }
}