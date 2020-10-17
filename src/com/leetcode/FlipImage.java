/*
author: hezhigang
date: 10/16/20
time: 10:55 PM
*/
package com.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 832. Flipping an Image
 * https://leetcode.com/problems/flipping-an-image/
 */
public class FlipImage {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Flipping an Image.
     * Memory Usage: 39.1 MB, less than 16.27% of Java online submissions for Flipping an Image.
     * @param A
     * @return
     */
    public static int[][] flipAndInvertImage(int[][] A) {
        final int N = A.length;
        final int M = A[0].length;
        int tmp;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                tmp = A[i][j];
                A[i][j] = A[i][N - 1 - j];
                A[i][N - 1 - j] = tmp;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = A[i][j] == 0 ? 1 : 0;
            }
        }
        return A;
    }

    public static void main(String[] args) {
//        int[][] A = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] A = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        System.out.println("Input: ");
        Stream.of(A).map(Arrays::toString).forEach(System.out::println);
        flipAndInvertImage(A);
        System.out.println("Output: ");
        Stream.of(A).map(Arrays::toString).forEach(System.out::println);
    }
}
