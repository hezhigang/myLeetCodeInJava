/*
author: hezhigang
date: 9/18/20
time: 2:30 PM
*/
package com.leetcode;

/**
 * 796. Rotate String
 * https://leetcode.com/problems/rotate-string/
 */
public class RotateString {

    /**
     * brute
     * @param A
     * @param B
     * @return
     */
    public static boolean rotateString_brute(String A, String B) {
        final int len_A = A.length();
        final int len_B = B.length();
        if (len_A != len_B)
            return false;
        if (A.isEmpty() && B.isEmpty())
            return true;
        for(int i=0; i<len_A; i++) {
            A = A.substring(1)+A.charAt(0);
            if (B.equals(A))
                return true;
        }
        return false;
    }

    /**
     * 19. How to check if two String is rotations of each other?
     * https://dev.to/javinpaul/20-basic-algorithms-problems-from-coding-interviews-4o76
     * @param A
     * @param B
     * @return
     */
    public static boolean rotateString(String A, String B) {
        final int len_A = A.length();
        final int len_B = B.length();
        if (len_A != len_B)
            return false;
        String s = A + A;
        return s.indexOf(B) != -1;
    }

    public static void main(String[] args) {
//        String A = "abcde", B = "cdeab";
//        String A = "abcde", B = "abced";
        String A = "aa", B = "a";
//        String A = "", B = "";
//        String A = "ohbrwzxvxe", B = "uornhegseo";
//        String A = "bbbacddceeb", B = "ceebbbbacdd";
        boolean b = rotateString(A, B);
        System.out.printf("%s %s become %s after some number of shifts", A, b ? "can" : "can't", B);
    }

    public static boolean rotateString_fault(String A, String B) {
        final int len_A = A.length();
        final int len_B = B.length();
        if (len_A != len_B)
            return false;
        if (A.isEmpty() && B.isEmpty())
            return true;
        int k = A.indexOf(B.charAt(0));
        if (k == -1)
            return false;
        else {
            int i = k;
            for (; i < len_A; i++) {
                if (A.charAt(i) == B.charAt(i - k)) {
                    continue;
                } else
                    break;
            }
            String s1 = A.substring(0, k);
            String s2 = B.substring(i - k);
            boolean b = s1.equals(s2);
            return b;
        }
    }
}
