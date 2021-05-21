/*
author: hezhigang
date: 5/21/21
time: 1:58 PM
*/
package com.leetcode;

/**
 * 504. Base 7
 * https://leetcode.com/problems/base-7/
 */
public class Base7 {

    public static String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }

    public static void main(String[] args) {
        int num = 100;
        System.out.printf("base 7 representation of %d : %s", num, convertToBase7(num));
    }
}
