/*
author: hezhigang
date: 10/17/20
time: 9:13 PM
*/
package com.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 1232. Check If It Is a Straight Line
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/
 */
public class CheckStraightLine {
    private static boolean isColine(int x1, int y1, int x2, int y2, int x3, int y3) {
        int a = (y3 - y2) * (x3 - x1);
        int b = (y3 - y1) * (x3 - x2);
        return a == b;
    }

    /**
     * 79 / 79 test cases passed.
     * Runtime: 1 ms, faster than 22.67% of Java online submissions for Check If It Is a Straight Line.
     * Memory Usage: 41 MB, less than 6.80% of Java online submissions for Check If It Is a Straight Line.
     * @param coordinates
     * @return
     */
    public static boolean checkStraightLine_my(int[][] coordinates) {
        final int N = coordinates.length;
        boolean b;
        for (int i = 0; i < N - 2; i++) {
            b = isColine(coordinates[i][0], coordinates[i][1], coordinates[i + 1][0], coordinates[i + 1][1], coordinates[i + 2][0], coordinates[i + 2][1]);
            if (b == false)
                return false;
        }
        return true;
    }

    /**
     * Shoelace formula, also known as Gauss's area formula
     * vertices must listed in clockwise(or counterclockwise) order.
     * https://en.wikipedia.org/wiki/Shoelace_formula
     * @param coordinates
     * @return
     */
    public static boolean checkStraightLine(int[][] coordinates) {
        final int N = coordinates.length;
        // vertices must listed in clockwise(or counterclockwise) order.
        Point2D[] a = new Point2D[N];
        for (int i = 0; i < N; i++) {
            a[i] = new Point2D(coordinates[i][0], coordinates[i][1]);
        }
        // preprocess so that a[0] has lowest y-coordinate
        Arrays.sort(a);
        // sort by polar angle with respect to base point a[0]
        Arrays.sort(a, 1, N, a[0].polarOrder());
        int A = a[N - 1].x() * a[0].y() - a[0].x() * a[N - 1].y();
        for (int i = 0; i < N - 1; i++) {
            A += a[i].x() * a[i + 1].y() - a[i + 1].x() * a[i].y();
        }
        return A == 0;
    }

    public static void main(String[] args) {
//        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
//        int[][] coordinates = {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
        int[][] coordinates = {{1, 1}, {2, 2}, {2, 1}, {3, 2}};
        Stream.of(coordinates).map(Arrays::toString).forEach(System.out::println);
        System.out.printf("%s a straight line", checkStraightLine(coordinates) ? "is" : "is not");
    }
}
