/*
author: hezhigang
date: 1/13/21
time: 3:49 AM
*/
package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1492. The kth Factor of n
 * https://leetcode.com/problems/the-kth-factor-of-n/
 */
public class NaturalNumberKthFactor {

    /**
     * Brute-force search
     * 207 / 207 test cases passed.
     * Runtime: 1 ms, faster than 43.15% of Java online submissions for The kth Factor of n.
     * Memory Usage: 35.8 MB, less than 48.68% of Java online submissions for The kth Factor of n.
     * @param n
     * @param k
     * @return
     */
    public static int kthFactor(int n, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                list.add(i);
        }
        if (list.size() < k)
            return -1;
        else
            return list.get(k - 1);
    }

    public static void main(String[] args) {
//        int n = 12, k = 3;
//        int n = 7, k = 2;
//        int n = 4, k = 4;
//        int n = 1, k = 1;
        int n = 1000, k = 3;
        System.out.printf("the %d-th factor of %d is %d.", k, n, kthFactor(n, k));
    }
}
