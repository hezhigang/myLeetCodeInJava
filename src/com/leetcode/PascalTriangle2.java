/**
 * 作者: 和志刚
 * 日期: 2018年9月4日
 * 时间: 下午9:38:42
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 119. Pascal's Triangle II
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalTriangle2 {
	
    public static List<Integer> getRow(int rowIndex) {
    	List<Integer> list = new ArrayList<Integer>();
    	if (rowIndex==0) {
    		list.add(1);
    		return list;
    	}
    	if (rowIndex==1) {
    		list.add(1);
    		list.add(1);
    		return list;
    	}    	
    	if (rowIndex>=2) {
    		List<Integer> row_pre = getRow(rowIndex-1);
    		list.add(1);
    		for(int i=1;i<rowIndex;i++) {
    			list.add(row_pre.get(i)+row_pre.get(i-1));
    		}
    		list.add(1);
    	}
    	return list;
    }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int rowIndex = 3;
		List<Integer> list = getRow(rowIndex);
		String s = list.stream().map(Object::toString).collect(Collectors.joining(" "));
		System.out.println(s);
	}

}
