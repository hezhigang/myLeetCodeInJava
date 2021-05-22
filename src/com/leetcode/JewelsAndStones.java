/*
author: hezhigang
date: 5/22/21
time: 2:38 PM
*/
package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. Jewels and Stones
 * https://leetcode.com/problems/jewels-and-stones/
 */
public class JewelsAndStones {

    /**
     * 255 / 255 test cases passed.
     * Runtime: 1 ms, faster than 64.92% of Java online submissions for Jewels and Stones.
     * Memory Usage: 37 MB, less than 89.30% of Java online submissions for Jewels and Stones.
     * @param jewels
     * @param stones
     * @return
     */
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> j = new HashSet<Character>();
        for (int i = 0; i < jewels.length(); i++)
            j.add(jewels.charAt(i));
        int n = 0;
        for (int i = 0; i < stones.length(); i++)
            if (j.contains(stones.charAt(i)))
                n++;
        return n;
    }
}
