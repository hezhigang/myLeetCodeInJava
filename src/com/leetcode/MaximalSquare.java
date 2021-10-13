/*
author: hezhigang
date: 10/13/21
time: 5:24 AM
*/
package com.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 221. Maximal Square
 * https://leetcode.com/problems/maximal-square/
 */
public class MaximalSquare {

    /**
     * 74 / 74 test cases passed.
     * Runtime: 5 ms, faster than 51.51% of Java online submissions for Maximal Square.
     * Memory Usage: 49 MB, less than 8.01% of Java online submissions for Maximal Square.
     * @param matrix
     * @return
     */
    public static int maximalSquare(char[][] matrix) {
        final int[][] D = {
                {-1, 0},  // up
                {0, -1},  // left
                {-1, -1}  // diagonal
        };
        int h = matrix.length;
        int w = matrix[0].length;
        int[][] countMatrix = new int[h][w];
        for (int i = 0; i < w; i++) {
            countMatrix[0][i] = matrix[0][i] == '1' ? 1 : 0;
        }
        if (h > 1) {
            for (int j = 1; j < h; j++) {
                countMatrix[j][0] = matrix[j][0] == '1' ? 1 : 0;
            }
            for (int i = 1; i < h; i++) {
                for (int j = 1; j < w; j++) {
                    if (matrix[i][j] == '1') {
                        int minCount = Integer.MAX_VALUE;
                        for (int k = 0; k < 3; k++) {
                            int x = i + D[k][0];
                            int y = j + D[k][1];
                            if (minCount > countMatrix[x][y])
                                minCount = countMatrix[x][y];
                        }
                        countMatrix[i][j] = minCount + 1;
                    } else {
                        countMatrix[i][j] = 0;
                    }
                }
            }
        }
        int maxCount = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (countMatrix[i][j] > maxCount)
                    maxCount = countMatrix[i][j];
            }
        }
        return maxCount * maxCount;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};

//        String[][] matrix = {{'0', '1'}, {'1', '0'}};

//        String[][] matrix = {{'0'}};

        int n = maximalSquare(matrix);

        System.out.println(n);
    }
}
