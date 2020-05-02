package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/
 */
public class RotateImage {

    /**
     * Rotate the image by 90 degrees (clockwise).
     * You have to rotate the image in-place
     * @param matrix, an n x n 2D matrix
     */
    public static void rotate(int[][] matrix) {
        int N = matrix.length;
        int tmp;
        for(int i=0; i<N; i++) {
            for(int j=0; j<i; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N/2; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][N-1-j];
                matrix[i][N-1-j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

//        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};

        System.out.println(Arrays.deepToString(matrix));

        Stream.of(matrix).map(Arrays::toString).forEach(System.out::println);

        rotate(matrix);

        System.out.println("after rotate: ");

        Stream.of(matrix).map(Arrays::toString).forEach(System.out::println);
    }
}