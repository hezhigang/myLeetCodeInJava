package com.leetcode;

/**
 * 1342. Number of Steps to Reduce a Number to Zero
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 */
public class CollatzConjectureKinda {

    public static int numberOfSteps(int num) {
        int i = 0;
        for (; num > 0; i++) {
            if ((num & 1) == 1) {
                num--;
            } else {
                num = num >> 1;
            }
        }
        return i;
    }

    public static int numberOfSteps_v1(int num) {
        int i = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                num--;
            } else {
                num = num >> 1;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        int num = 14;
//        int num = 8;
//        int num = 123;
        int count = numberOfSteps(num);
        System.out.printf("Number of Steps to Reduce %d to Zero = %d", num, count);
    }
}
