package com.leetcode;

public class AddTwoIntegers {

    /**
     * 262 / 262 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Add Two Integers.
     * Memory Usage: 40.7 MB, less than 78.42% of Java online submissions for Add Two Integers.
     * @param num1
     * @param num2
     * @return
     */
    public static int sum(int num1, int num2) {
        return num1 + num2;
    }

    public static void main(String[] args) {
        int num1 = 12, num2 = 5;
        int sum = sum(num1, num2);
        System.out.printf("%d + %d = %d", num1, num2, sum);
        System.out.println();
    }
}
