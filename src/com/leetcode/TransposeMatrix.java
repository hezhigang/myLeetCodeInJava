package com.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 867. Transpose Matrix
 * https://leetcode.com/problems/transpose-matrix
 */
public class TransposeMatrix {

    public static int[][] transpose(int[][] A) {
        int h = A.length;
        int w = A[0].length;
        int[][] B = new int[w][h];
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++)
                B[j][i]=A[i][j];
        }
        return B;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}};
//        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Stream.of(A).map(Arrays::toString).forEach(System.out::println);
        int[][] B = transpose(A);
        System.out.println("after transpose: ");
        Stream.of(B).map(Arrays::toString).forEach(System.out::println);
    }
}
