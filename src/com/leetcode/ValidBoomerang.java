package com.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author hezhigang
 * 1037. Valid Boomerang
 * https://leetcode.com/problems/valid-boomerang/
 */
public class ValidBoomerang {
	
    public static boolean isBoomerang(int[][] points) {
        boolean r = true;
        int a = (points[2][1]-points[0][1])*(points[1][0]-points[0][0]);
        int b = (points[1][1]-points[0][1])*(points[2][0]-points[0][0]);
        if (a==b)
        	r = false;
        return r;
    }

	public static void main(String[] args) {
//		int[][] points = {
//				{1,1},
//				{2,3},
//				{3,2}
//		};
		
		int[][] points = {
				{1,1},
				{2,2},
				{3,3}
		};
		
		Stream.of(points).map(Arrays::toString).forEach(System.out::println);
		
		boolean b = isBoomerang(points);
		System.out.println("is " + (b?"":"not ") + "a boomerang");
		
	}

}
