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

    /**
     * non in-place method
     * How to rotate the positions of a matrix by 90 degrees
     * https://math.stackexchange.com/questions/1676441/how-to-rotate-the-positions-of-a-matrix-by-90-degrees
     * @param matrix
     * @return
     */
    public static int[][] rotate_math_stackexchange(int[][] matrix) {
        int N = matrix.length;
        int[][] R = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                // counter-clockwise
//                R[i][j] = matrix[j][N-1-i];
                // clocckwise
                R[i][j] = matrix[N-1-j][i];
            }
        }
        return R;
    }

    /**
     * Rotate a matrix by 90 degree in clockwise direction without using any extra space
     * https://www.geeksforgeeks.org/rotate-a-matrix-by-90-degree-in-clockwise-direction-without-using-any-extra-space/
     * @param matrix
     */
    public static void rotate2(int[][] matrix) {
        int N = matrix.length;
        int tmp;
        for(int i=0; i<N/2; i++) {
            for(int j=i; j<N-i-1; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[N-1-j][i];
                matrix[N-1-j][i] = matrix[N-1-i][N-1-j];
                matrix[N-1-i][N-1-j] = matrix[j][N-1-i];
                matrix[j][N-1-i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};

        System.out.println(Arrays.deepToString(matrix));

        Stream.of(matrix).map(Arrays::toString).forEach(System.out::println);

        int[][] B = rotate_math_stackexchange(matrix);

        rotate(matrix);

        System.out.println("after rotate: ");
        Stream.of(matrix).map(Arrays::toString).forEach(System.out::println);

        System.out.println("matrix rotate: ");
        Stream.of(B).map(Arrays::toString).forEach(System.out::println);
    }
}