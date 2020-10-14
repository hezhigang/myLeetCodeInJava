/*
author: hezhigang
date: 10/14/20
time: 10:27 AM
*/
package com.leetcode;

import java.util.Arrays;

/**
 * 384. Shuffle an Array
 * https://leetcode.com/problems/shuffle-an-array/
 * 10 / 10 test cases passed.
 * Runtime: 76 ms, faster than 76.75% of Java online submissions for Shuffle an Array.
 * Memory Usage: 47.2 MB, less than 6.24% of Java online submissions for Shuffle an Array.
 */
public class ShuffleArray3 {
    private int[] shuffleArr;
    private int[] originalArr;

    public ShuffleArray3(int[] nums) {
        originalArr = nums.clone();
        shuffleArr = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originalArr;
    }

    /**
     * the Knuth (or Fisher-Yates) shuffling algorithm
     * @return Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        final int N = shuffleArr.length;
        int swap;
        for (int i = 0; i < N; i++) {
            // choose index uniformly in [0, i]
            int r = (int) (Math.random() * (i + 1));
            swap = shuffleArr[r];
            shuffleArr[r] = shuffleArr[i];
            shuffleArr[i] = swap;
        }
        return shuffleArr;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ShuffleArray3 obj = new ShuffleArray3(nums);
        int[] original = obj.reset();
        System.out.printf("original: %s\n\r", Arrays.toString(original));
        int[] shuffle = obj.shuffle();
        System.out.printf("the random shuffling of array: %s\n\r", Arrays.toString(shuffle));
    }
}
