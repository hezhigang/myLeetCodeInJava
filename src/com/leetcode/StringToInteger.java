package com.leetcode;

/**
 * 8. String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToInteger {

    /**
     * 1082 / 1082 test cases passed.
     * Runtime: 5 ms, faster than 26.19% of Java online submissions for String to Integer (atoi).
     * Memory Usage: 38.9 MB, less than 80.12% of Java online submissions for String to Integer (atoi).
     * @param s
     * @return
     */
    public static int myAtoi(String s) {
        int re = 0;
        long num = 0;
        s = s.trim();
        char[] a = s.toCharArray();
        int len = a.length;
        int[] digits = new int[len];
        int k = 0;
        boolean isNegative = false;
        char c = ' ';
        if (len > 0) {
            boolean hasSignFlag = false;
            if (a[0] == '+' || a[0] == '-')
                hasSignFlag = true;
            if (a[0] == '-')
                isNegative = true;
            if (a[0] == '+')
                isNegative = false;
            for (int i = hasSignFlag ? 1 : 0; i < len; i++) {
                c = a[i];
                if (Character.isDigit(c))
                    digits[k++] = Integer.parseInt(c + "");
                else if (!Character.isDigit(c))
                    break;
                else
                    ;
            }
        }
        for (int m = 0; m < k; m++)
            num += digits[m] * Math.pow(10, k - m - 1);
        if (isNegative)
            num *= -1;
        if (num < Integer.MIN_VALUE)
            num = Integer.MIN_VALUE;
        if (num > Integer.MAX_VALUE)
            num = Integer.MAX_VALUE;
        re = new Long(num).intValue();
        return re;
    }

    public static void main(String[] args) {
//        String s = "42";
//        String s = "   -42";
//        String s = "4193 with words";
//        String s = "-91283472332";
//        String s = "+1";
        String s = "+-12";
        int n = myAtoi(s);
        System.out.printf("converts %s to a 32-bit signed integer=%d", s, n);
        System.out.println();
    }

}
