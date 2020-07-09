package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 66. Plus One
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        final int N = digits.length;
        int[] a2 = new int[N];
        boolean carry = false;
        int tmp = digits[N - 1] + 1;
        if (tmp < 10) {
            a2[N - 1] = (tmp);
        } else {
            a2[N - 1] = tmp - 10;
            carry = true;
        }
        for (int i = N - 2; i >= 0; i--) {
            tmp = digits[i];
            if (carry)
                tmp++;
            if (tmp < 10) {
                carry = false;
                a2[i] = tmp;
            } else {
                carry = true;
                a2[i] = tmp - 10;
            }
        }
        if (carry) {
            int[] a1 = new int[N + 1];
            a1[0] = 1;
            System.arraycopy(a2, 0, a1, 1, N);
            return a1;
        } else
            return a2;
    }

    public static int[] plusOne_v2(int[] digits) {
        final int N = digits.length;
        List<Integer> list = new ArrayList<Integer>();
        boolean carry = false;
        int tmp = digits[N - 1] + 1;
        if (tmp < 10) {
            list.add(tmp);
        } else {
            list.add(tmp - 10);
            carry = true;
        }
        for (int i = N - 2; i >= 0; i--) {
            tmp = digits[i];
            if (carry)
                tmp++;
            if (tmp < 10) {
                carry = false;
                list.add(tmp);
            } else {
                carry = true;
                list.add(tmp - 10);
            }
        }
        if (carry)
            list.add(1);

        final int LEN = list.size();
        int[] a = new int[LEN];
        for (int i = 0; i < LEN; i++) {
            a[LEN - i - 1] = list.get(i).intValue();
        }
        return a;
    }

    public static int[] plusOne_v1(int[] digits) {
        final int N = digits.length;
        List<Integer> list = new ArrayList<Integer>();
        boolean carry = false;
        int tmp = digits[N - 1] + 1;
        if (tmp < 10) {
            list.add(tmp);
        } else {
            list.add(tmp % 10);
            carry = true;
        }
        if (N >= 2) {
            for (int i = N - 2; i >= 0; i--) {
                tmp = digits[i];
                if (carry)
                    tmp++;
                if (tmp < 10) {
                    carry = false;
                    list.add(tmp);
                } else {
                    carry = true;
                    list.add(tmp % 10);
                }
            }
        }
        if (carry)
            list.add(1);

        final int LEN = list.size();
        int[] a = new int[LEN];
        for (int i = 0; i < LEN; i++) {
            a[LEN - i - 1] = list.get(i).intValue();
        }
        return a;
    }

    public static int[] plusOne_wrong(int[] digits) {
        final int N = digits.length;
        long x = 0;
        for (int i = 0; i < N; i++) {
            x += digits[i] * (new Double(Math.pow(10, N - 1 - i)).longValue());
        }
        x++;

        String s = new Long(x).toString();
        final int LEN = s.length();
        int[] a = new int[LEN];
        char[] charDigits = s.toCharArray();
        for (int i = 0; i < charDigits.length; i++) {
            a[i] = Integer.parseInt(String.valueOf(charDigits[i]));
        }
        return a;
    }

    public static void main(String[] args) {
//        int[] digits = { 1, 2, 3 };
//        int[] digits = { 4, 3, 2, 1 };
        int[] digits = { 9, 9, 9 };
//        int[] digits = { 9 };
//        int[] digits = { 7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6 };
        System.out.printf("Input: %s\n\r", Arrays.toString(digits));
        int[] digits_out = plusOne(digits);
        System.out.printf("Output: %s", Arrays.toString(digits_out));
    }
}
