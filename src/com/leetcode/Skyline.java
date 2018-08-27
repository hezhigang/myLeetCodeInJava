/**
 * 作者: 和志刚
 * 日期: 2018年8月2日
 * 时间: 上午11:15:38
 */
package com.leetcode;

import java.util.List;

/**
 * 218. The Skyline Problem
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance.
 */
public class Skyline {
	
    public List<int[]> getSkyline(int[][] buildings) {
        return null;
    }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] buildings = {
				{2,9,10}, 
				{3,7,15}, 
				{5,12,12}, 
				{15,20,10}, 
				{19,24,8}
			};
		for(int i=0;i<buildings.length;i++) {
			System.out.println("Li="+buildings[i][0]+", Ri="+buildings[i][1]+", Hi="+buildings[i][2]);
		}
	}

}
