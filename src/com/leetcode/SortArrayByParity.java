/*
author: hezhigang
date: 10/16/20
time: 1:29 PM
*/
package com.leetcode;

import java.util.Arrays;

/**
 * 905. Sort Array By Parity
 * https://leetcode.com/problems/sort-array-by-parity/
 */
public class SortArrayByParity {
    /**
     * Two Pass
     * 285 / 285 test cases passed.
     * Runtime: 1 ms, faster than 99.47% of Java online submissions for Sort Array By Parity.
     * Memory Usage: 40.1 MB, less than 30.13% of Java online submissions for Sort Array By Parity.
     * @param A
     * @return
     */
    public static int[] sortArrayByParity_twopass(int[] A) {
        final int N = A.length;
        int[] B = new int[N];
        int left = 0, right = N - 1;
        for (int i = 0; i < N; i++) {
            if ((A[i] & 1) == 0) {
                B[left++] = A[i];
            } else {
                B[right--] = A[i];
            }
        }
        return B;
    }

    /**
     * In-Place
     * https://leetcode.com/problems/sort-array-by-parity/solution/
     * @param A
     * @return
     */
    public static int[] sortArrayByParity(int[] A) {
        final int N = A.length;
        int left = 0, right = N - 1;
        int temp;
        while (left < right) {
            if ((A[left] & 1) == 1 && (A[right] & 1) == 0) {
                temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }
            if ((A[left] & 1) == 0) left++;
            if ((A[right] & 1) == 1) right--;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4};
        System.out.printf("Input: %s\n\r", Arrays.toString(A));
        sortArrayByParity(A);
        System.out.printf("Output: %s", Arrays.toString(A));
//        int[] B = sortArrayByParity(A);
//        System.out.printf("Input: %s, \n\rOutput: %s", Arrays.toString(A), Arrays.toString(B));
    }
}
