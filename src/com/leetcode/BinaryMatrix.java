package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * 542. 01 Matrix
 * https://leetcode.com/problems/01-matrix/
 */
public class BinaryMatrix {

    final static int d[][] = {
            {0,1},  //right
            {1,0},  //down
            {0,-1}, //left
            {-1,0}  //up
    };

    /**
     * Using BFS
     * https://leetcode.com/problems/01-matrix/solution/
     * @param matrix
     * @return
     */
    public static int[][] updateMatrix(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        int[][] dist = new int[h][w];

        for(int i=0;i<h;i++) {
            for(int j=0;j<w;j++) {
                dist[i][j]=Integer.MAX_VALUE;
            }
        }

        Queue<int[]> queue = new LinkedList<int[]>();
        for(int i=0;i<h;i++) {
            for(int j=0;j<w;j++) {
                if (matrix[i][j]==0) {
                    dist[i][j]=0;
                    queue.add(new int[]{i,j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            for (int i = 0; i < 4; i++) {
                int x = row + d[i][0];
                int y = col + d[i][1];
                if (isValid(matrix, h, w, x, y)) {
                    if (dist[x][y]>dist[row][col]+1) {
                        dist[x][y] = dist[row][col]+1;
                        queue.add(new int[]{x,y});
                    }
                }
            }
        }

        return dist;
    }

    private static boolean isValid(int[][] grid, int width, int height, int row, int col) {
        return (row >= 0) && (row < width) && (col >= 0) && (col < height);
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                { 0,0,0 },
//                { 0,1,0 },
//                { 0,0,0 }
//        };

        int[][] matrix = {
                { 0,0,0 },
                { 0,1,0 },
                { 1,1,1 }
        };

        Stream.of(matrix).map(Arrays::toString).forEach(System.out::println);

        System.out.println();

        int[][] dist = updateMatrix(matrix);

        Stream.of(dist).map(Arrays::toString).forEach(System.out::println);
    }
}
