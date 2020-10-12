/*
author: hezhigang
date: 10/11/20
time: 8:04 PM
*/
package com.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 1572. Matrix Diagonal Sum
 * https://leetcode.com/problems/matrix-diagonal-sum/
 */
public class MatrixDiagonalSum {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Matrix Diagonal Sum.
     * Memory Usage: 39.5 MB, less than 16.30% of Java online submissions for Matrix Diagonal Sum.
     * @param mat
     * @return
     */
    public static int diagonalSum(int[][] mat) {
        final int N = mat.length;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += mat[i][i];
            if ((N - 1) != 2 * i)
                sum += mat[i][N - 1 - i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

//        int[][] mat = {{1, 1, 1, 1},
//                {1, 1, 1, 1},
//                {1, 1, 1, 1},
//                {1, 1, 1, 1}};

//        int[][] mat = {{5}};

//        System.out.println(Arrays.deepToString(mat));

        int sum = diagonalSum(mat);
        Stream.of(mat).map(Arrays::toString).forEach(System.out::println);
        System.out.printf("the sum of the matrix diagonals = %d", sum);
    }
}
