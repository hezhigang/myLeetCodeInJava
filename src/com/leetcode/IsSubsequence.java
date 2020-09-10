package com.leetcode;

/**
 * 392. Is Subsequence
 * https://leetcode.com/problems/is-subsequence/
 */
public class IsSubsequence {

    /**
     * binary search
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence_binarysearch(String s, String t) {
        boolean b = true;
        final int len_s = s.length();
        final int len_t = t.length();
        
        return b;
    }

    /**
     * Recursion
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        boolean b = true;
        final int len_s = s.length();
        if (len_s > 0) {
            int i = t.indexOf(s.charAt(0));
            if (i != -1)
                return isSubsequence(s.substring(1), t.substring(++i));
            else
                return false;
        }
        return b;
    }

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
//        String s = "axc", t = "ahbgdc";
//        String s = "aaaaaa", t = "bbaaaa";
        boolean b =isSubsequence(s,t);
        System.out.printf("%s %s subsequence of %s", s, b?"is":"is not",t);
    }
}
