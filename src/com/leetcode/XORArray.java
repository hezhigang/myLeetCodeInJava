package com.leetcode;

/**
 * 1486. XOR Operation in an Array
 * https://leetcode.com/problems/xor-operation-in-an-array/
 */
public class XORArray {

    public static int xorOperation(int n, int start) {
        int r = start;
        for (; n > 1; n--) {
            start += 2;
            r = r ^ start;
        }
        return r;
    }

    public static void main(String[] args) {
//        int n = 5, start = 0;
//        int n = 4, start = 3;
//        int n = 1, start = 7;
        int n = 10, start = 5;
        System.out.printf("the bitwise XOR of all elements = " + xorOperation(n, start));
    }
}
