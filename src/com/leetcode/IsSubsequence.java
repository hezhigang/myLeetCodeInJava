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
    public static boolean isSubsequence_recur(String s, String t) {
        boolean b = true;
        final int len_s = s.length();
        if (len_s > 0) {
            int i = t.indexOf(s.charAt(0));
            if (i != -1)
                return isSubsequence_recur(s.substring(1), t.substring(++i));
            else
                return false;
        }
        return b;
    }

    /**
     * Iterative
     * https://leetcode.com/problems/is-subsequence/discuss/957128/JAVA-clean-quick-concise-solution.
     * 15 / 15 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Is Subsequence.
     * Memory Usage: 37.1 MB, less than 39.06% of Java online submissions for Is Subsequence.
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        final int len_s = s.length();
        final int len_t = t.length();
        if (len_s > len_t)
            return false;
        int i = 0;
        for (int j = 0; j < len_t && i < len_s; ) {
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i >= len_s;
    }

    public static void main(String[] args) {
//        String s = "abc", t = "ahbgdc";
//        String s = "axc", t = "ahbgdc";
        String s = "aaaaaa", t = "bbaaaa";
        boolean b =isSubsequence(s,t);
        System.out.printf("%s %s subsequence of %s", s, b?"is":"is not",t);
    }
}