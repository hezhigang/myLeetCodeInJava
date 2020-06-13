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
        int a = (points[2][1]-points[0][1])*(points[1][0]-points[0][0]);
        int b = (points[1][1]-points[0][1])*(points[2][0]-points[0][0]);
        return a!=b;
    }

	/**
	 * fault method
	 * @param points
	 * @return
	 */
	public static boolean isBoomerang2(int[][] points) {
		double len_ab = Math.sqrt(Math.pow(points[1][0] - points[0][0], 2) + Math.pow(points[1][1] - points[0][1], 2));
		double len_bc = Math.sqrt(Math.pow(points[2][0] - points[1][0], 2) + Math.pow(points[2][1] - points[1][1], 2));
		double len_ac = Math.sqrt(Math.pow(points[2][0] - points[0][0], 2) + Math.pow(points[2][1] - points[0][1], 2));
		System.out.printf("%f+%f=%f\n", len_ab, len_bc, len_ac);
		return len_ab + len_bc != len_ac;
	}

	/**
	 * calculate the area of a triangle by Heron's formula
	 * accept by leetcode
	 * @param points
	 * @return
	 */
	public static boolean isBoomerang3(int[][] points) {
		double a = Math.sqrt(Math.pow(points[1][0] - points[0][0], 2) + Math.pow(points[1][1] - points[0][1], 2));
		double b = Math.sqrt(Math.pow(points[2][0] - points[1][0], 2) + Math.pow(points[2][1] - points[1][1], 2));
		double c = Math.sqrt(Math.pow(points[2][0] - points[0][0], 2) + Math.pow(points[2][1] - points[0][1], 2));
		System.out.printf("a=%f, b=%f, c=%f\n", a, b, c);
		double s = (a + b + c) / 2;
		double A = Math.sqrt(s * (s - a) * (s - b) * (s - c));
		return A != 0;
	}

	/**
	 * Gauss's area formula
	 * https://en.wikipedia.org/wiki/Shoelace_formula
	 * @param points
	 * @return
	 */
	public static boolean isBoomerang4(int[][] points) {
		double A = Math.abs((points[0][0] * points[1][1] + points[1][0] * points[2][1] + points[2][0] * points[0][1]
				- points[1][0] * points[0][1] - points[2][0] * points[1][1] - points[0][0] * points[2][1]) / 2.0);
		return A != 0;
	}

	public static void main(String[] args) {
		int[][] points = { { 1, 1 }, { 2, 3 }, { 3, 2 } };

//		int[][] points = { { 1, 1 }, { 2, 2 }, { 3, 3 } };

//		int[][] points = { { 0, 1 }, { 1, 0 }, { 0, 1 } };

		Stream.of(points).map(Arrays::toString).forEach(System.out::println);
		
		boolean b = isBoomerang(points);
		System.out.println("is " + (b?"":"not ") + "a boomerang");

		boolean b2 = isBoomerang2(points);
		System.out.println("is " + (b2?"":"not ") + "a boomerang");

		boolean b3 = isBoomerang3(points);
		System.out.println("is " + (b3?"":"not ") + "a boomerang");

		boolean b4 = isBoomerang4(points);
		System.out.println("is " + (b4?"":"not ") + "a boomerang");
	}

}
