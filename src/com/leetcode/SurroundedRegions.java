package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * 130. Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundedRegions {

    private final static int d[][] = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public static void solve(char[][] board) {
        int h = board.length;
        int w = h==0 ? 0 : board[0].length;

        if (h==0 || w==0) return;

        for (int j = 0; j < w; j++) {
            if (board[0][j] == 'O') bfs(0, j, board, h, w);
            if (board[h - 1][j] == 'O') bfs(h - 1, j, board, h, w);
        }

        for (int i = 1; i < h-1; i++) {
            if (board[i][0] == 'O') bfs(i, 0, board, h, w);
            if (board[i][w - 1] == 'O') bfs(i, w - 1, board, h, w);
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'B') board[i][j] = 'O';
            }
        }
    }

    private static void bfs(int i, int j, char[][] board, int h, int w) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i,j));
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            int row = curr.x;
            int col =  curr.y;
            if (isValid(board, h, w, row, col)) {
                board[row][col] = 'B';
                for (int[] c: d) {
                    int x = curr.x + c[0];
                    int y = curr.y + c[1];
                    queue.add(new Point(x, y));
                }
            }
        }
    }

    private static boolean isValid(char[][] grid, int width, int height, int row, int col) {
        return (row >= 0) && (row < width) && (col >= 0) && (col < height) && grid[row][col] == 'O';
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        Stream.of(board).map(Arrays::toString).forEach(System.out::println);

        System.out.println();

        solve(board);
        Stream.of(board).map(Arrays::toString).forEach(System.out::println);
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
