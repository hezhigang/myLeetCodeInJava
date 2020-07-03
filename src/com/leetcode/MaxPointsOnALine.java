package com.leetcode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 149. Max Points on a Line
 * https://leetcode.com/problems/max-points-on-a-line/
 */
public class MaxPointsOnALine {
    private static final int BIGDECIMAL_SCALE = 16;

    public static int maxPoints(int[][] points) {
        int n = 0;
        for (int i = 0; i < points.length; i++) {
            int m = maxCollinearPoints(points, i);
            if (m > n)
                n = m;
        }
        return n;
    }

    private static int maxCollinearPoints(int[][] points, int idx) {
        Map<BigDecimal, Integer> map = new HashMap<BigDecimal, Integer>();
        int x0 = points[idx][0];
        int y0 = points[idx][1];
        int x = 0, y = 0;
        int duplicate = 1;
        int vertical = 0;
        for (int i = 0; i < points.length; i++) {
            if (i != idx) {
                x = points[i][0];
                y = points[i][1];
                if (x == x0) {
                    if (y == y0) {
                        duplicate++;
                    }
                    else {
                        vertical++;
                    }
                } else {
                    BigDecimal deltaY = BigDecimal.valueOf(y - y0);
                    BigDecimal deltaX = BigDecimal.valueOf(x - x0);
                    BigDecimal slope = deltaY.divide(deltaX, BIGDECIMAL_SCALE, RoundingMode.FLOOR);
                    if (map.containsKey(slope)) {
                        map.put(slope, map.get(slope) + 1);
                    } else {
                        map.put(slope, 1);
                    }
                }

            }
        }
        int max = 0;
        for (Integer num : map.values()) {
            if (num + duplicate > max)
                max = num + duplicate;
        }
        if ( (vertical + duplicate) > max )
            max = vertical + duplicate;
        return max;
    }

    /**
     * LeetCode – Max Points on a Line (Java)
     * https://www.programcreek.com/2014/04/leetcode-max-points-on-a-line-java/
     * This problem can be solve by counting points that have the same slope for each point.
     * When counting, we need to be careful about the duplicate points and points on the vertical lines.
     * @param points
     * @return
     */
    public static int maxPoints_programcreek(int[][] points) {
        HashMap<BigDecimal, Integer> result = new HashMap<BigDecimal, Integer>();
        int max = 0;

        for (int i = 0; i < points.length; i++) {
            int duplicate = 1;
            int vertical = 0;
            for (int j = i + 1; j < points.length; j++) {
                //handle duplicates and vertical
                if (points[i][0] == points[j][0]) {
                    if (points[i][1] == points[j][1]) {
                        duplicate++;
                    } else {
                        vertical++;
                    }
                } else {
                    BigDecimal slope =
                            points[j][1] == points[i][1] ? BigDecimal.valueOf(0.0) : BigDecimal.valueOf(1.0 * (points[j][1] - points[i][1]))
                                    .divide(BigDecimal.valueOf(points[j][0] - points[i][0]), BIGDECIMAL_SCALE,
                                            RoundingMode.FLOOR);

                    if (result.get(slope) != null) {
                        result.put(slope, result.get(slope) + 1);
                    } else {
                        result.put(slope, 1);
                    }
                }
            }

            for (Integer count : result.values()) {
                if (count + duplicate > max) {
                    max = count + duplicate;
                }
            }

            max = Math.max(vertical + duplicate, max);
            result.clear();
        }

        return max;
    }

    public static void main(String[] args) {
//        int[][] points = { { 1, 1 }, { 2, 2 }, { 3, 3 } };
        int[][] points = { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };
//        int[][] points = { { 1, 1 }, { 1, 1 }, { 2, 2 }, { 2, 2 } };
//        int[][] points = { { 0, 0 }, { 0, 0 } };

//        int[][] points = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
//        int[][] points = {{0,0},{94911151,94911150},{94911152,94911151}};

        /*
        int[][] points = { { 15, 12 }, { 9, 10 }, { -16, 3 }, { -15, 15 }, { 11, -10 }, { -5, 20 }, { -3, -15 },
                { -11, -8 }, { -8, -3 }, { 3, 6 }, { 15, -14 }, { -16, -18 }, { -6, -8 }, { 14, 9 }, { -1, -7 },
                { -1, -2 }, { 3, 11 }, { 6, 20 }, { 10, -7 }, { 0, 14 }, { 19, -18 }, { -10, -15 }, { -17, -1 },
                { 8, 7 }, { 20, -18 }, { -4, -9 }, { -9, 16 }, { 10, 14 }, { -14, -15 }, { -2, -10 }, { -18, 9 },
                { 7, -5 }, { -12, 11 }, { -17, -6 }, { 5, -17 }, { -2, -20 }, { 15, -2 }, { -5, -16 }, { 1, -20 },
                { 19, -12 }, { -14, -1 }, { 18, 10 }, { 1, -20 }, { -15, 19 }, { -18, 13 }, { 13, -3 }, { -16, -17 },
                { 1, 0 }, { 20, -18 }, { 7, 19 }, { 1, -6 }, { -7, -11 }, { 7, 1 }, { -15, 12 }, { -1, 7 }, { -3, -13 },
                { -11, 2 }, { -17, -5 }, { -12, -14 }, { 15, -3 }, { 15, -11 }, { 7, 3 }, { 19, 7 }, { -15, 19 },
                { 10, -14 }, { -14, 5 }, { 0, -1 }, { -12, -4 }, { 4, 18 }, { 7, -3 }, { -5, -3 }, { 1, -11 },
                { 1, -1 }, { 2, 16 }, { 6, -6 }, { -17, 9 }, { 14, 3 }, { -13, 8 }, { -9, 14 }, { -5, -1 },
                { -18, -17 }, { 9, -10 }, { 19, 19 }, { 16, 7 }, { 3, 7 }, { -18, -12 }, { -11, 12 }, { -15, 20 },
                { -3, 4 }, { -18, 1 }, { 13, 17 }, { -16, -15 }, { -9, -9 }, { 15, 8 }, { 19, -9 }, { 9, -17 } };

         */

        /*
        int[][] points = { { 0, -12 }, { 5, 2 }, { 2, 5 }, { 0, -5 }, { 1, 5 }, { 2, -2 }, { 5, -4 }, { 3, 4 },
                { -2, 4 }, { -1, 4 }, { 0, -5 }, { 0, -8 }, { -2, -1 }, { 0, -11 }, { 0, -9 } };

         */

        Stream.of(points).map(Arrays::toString).forEach(System.out::println);

        System.out.println();

        int num = maxPoints(points);
        System.out.printf("the maximum number of points that lie on the same straight line = %d\n", num);

        int num2 = maxPoints_programcreek(points);
        System.out.printf("the maximum number of points that lie on the same straight line = %d\n", num2);

    }
}
