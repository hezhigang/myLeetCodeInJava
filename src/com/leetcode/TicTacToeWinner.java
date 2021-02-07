/*
author: hezhigang
date: 1/25/21
time: 10:21 PM
*/
package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 1275. Find Winner on a Tic Tac Toe Game
 * https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
 */
public class TicTacToeWinner {

    private static boolean realContain(List<int[]> list, int[][] arr) {
        boolean b = true;
        for (int i = 0; i < arr.length; i++) {
            boolean b2 = false;
            for (int j = 0; j < list.size(); j++) {
                b2 = b2 || ((arr[i][0] == list.get(j)[0]) && (arr[i][1] == list.get(j)[1]));
            }
            b = b && b2;
        }
        return b;
    }

    private static boolean hasWin(List<int[]> list) {
        int[][] a1 = {{0, 0},{0, 1},{0, 2}};
        int[][] a2 = {{1, 0},{1, 1},{1, 2}};
        int[][] a3 = {{2, 0},{2, 1},{2, 2}};
        int[][] a4 = {{0, 0},{1, 0},{2, 0}};
        int[][] a5 = {{0, 1},{1, 1},{2, 1}};
        int[][] a6 = {{0, 2},{1, 2},{2, 2}};
        int[][] a7 = {{0, 0},{1, 1},{2, 2}};
        int[][] a8 = {{0, 2},{1, 1},{2, 0}};
        boolean r = realContain(list, a1) || realContain(list, a2) || realContain(list, a3)
                || realContain(list, a4) || realContain(list, a5) || realContain(list, a6)
                || realContain(list, a7) || realContain(list, a8);
        return r;
    }

    /**
     * 100 / 100 test cases passed.
     * Runtime: 2 ms, faster than 8.21% of Java online submissions for Find Winner on a Tic Tac Toe Game.
     * Memory Usage: 38.9 MB, less than 6.40% of Java online submissions for Find Winner on a Tic Tac Toe Game.
     * @param moves
     * @return
     */
    public static String tictactoe(int[][] moves) {
        final int len = moves.length;
        List<int[]> listX = new ArrayList<int[]>();
        List<int[]> listO = new ArrayList<int[]>();
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0)
                listX.add(moves[i]);
            else
                listO.add(moves[i]);
        }
        String r = "";
        if (hasWin(listX))
            r = "A";
        else if (hasWin(listO))
            r = "B";
        else if (len == 9)
            r = "Draw";
        else
            r = "Pending";
        return r;
    }

    public static void main(String[] args) {
//        int[][] moves = {{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};
//        int[][] moves = {{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}};
        int[][] moves = {{0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}};
//        int[][] moves = {{0, 0}, {1, 1}};
        String s = tictactoe(moves);
        Stream.of(moves).map(Arrays::toString).forEach(System.out::println);
        System.out.println();
        System.out.printf("Find Winner on a Tic Tac Toe Game -> %s", s);
    }
}
