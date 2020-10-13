/*
author: hezhigang
date: 10/13/20
time: 2:10 PM
*/
package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1002. Find Common Characters
 * https://leetcode.com/problems/find-common-characters/
 */
public class FindCommonCharacters {

    /**
     * 83 / 83 test cases passed.
     * Runtime: 7 ms, faster than 53.85% of Java online submissions for Find Common Characters.
     * Memory Usage: 39.4 MB, less than 7.83% of Java online submissions for Find Common Characters.
     * @param A
     * @return
     */
    public static List<String> commonChars(String[] A) {
        List<String> clist = new ArrayList<String>();
        final int N = A.length;
        int[][] counter = new int[26][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                counter[A[i].charAt(j) - 'a'][i]++;
            }
        }

        int m;
        String s = "";
        for (int i = 0; i < 26; i++) {
            m = counter[i][0];
            for (int j = 1; j < N; j++) {
                if (counter[i][j] < m)
                    m = counter[i][j];
            }
            if (m > 0) {
                s = (char) (i + 'a') + "";
                for (; m > 0; m--) {
                    clist.add(s);
                }
            }
        }
        return clist;
    }

    public static void main(String[] args) {
        String[] A = {"bella", "label", "roller"};
//        String[] A = {"cool", "lock", "cook"};
        System.out.printf("Input: %s", Arrays.toString(A));
        System.out.println();
        List<String> list = commonChars(A);
        System.out.printf("common characters are: %s", list.stream().map(Object::toString).collect(Collectors.joining(",")));
    }
}
