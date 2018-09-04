/**
 * 作者: 和志刚
 * 日期: 2018年8月28日
 * 时间: 下午3:04:12
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 118. Pascal's Triangle
 * Given a non-negative integer numRows, 
 * generate the first numRows of Pascal's triangle.
 */
public class PascalTriangle {
	
	/**
	 * 
	 * @param numRows
	 * @return
	 */
    public static List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	
    	if (numRows==1) {
        	List<Integer> list0 = new ArrayList<Integer>();
        	list0.add(1);
        	list.add(list0);
        	return list;    		
    	}
    	
    	if (numRows==2) {
        	List<Integer> list0 = new ArrayList<Integer>();
        	list0.add(1);
        	list.add(list0);    		
        	List<Integer> list1 = new ArrayList<Integer>();
        	list1.add(1);
        	list1.add(1);
        	list.add(list1);
        	return list;    		
    	}
    	
    	if (numRows>=3) {
        	List<List<Integer>> list_= generate(numRows-1);
        	List<Integer> list_pre = list_.get(numRows-2);
        	for(int i=0;i<list_.size();i++)
        		list.add(list_.get(i));
        	List<Integer> list_curr = new ArrayList<Integer>();
        	list_curr.add(1);
        	for(int i=1;i<numRows-1;i++) {
        		list_curr.add(list_pre.get(i)+list_pre.get(i-1));
        	}
        	list_curr.add(1);
        	list.add(list_curr);
    	}
        return list;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<List<Integer>> list = generate(5);
//		List<List<Integer>> list = generate(11);
		System.out.println( list.stream().map(Object::toString).collect(Collectors.joining("\n")) );
	}

}
