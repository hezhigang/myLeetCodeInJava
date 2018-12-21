/**
 * 作者: 和志刚
 * 日期: 2018年12月21日
 * 时间: 上午2:42:44
 */
package com.leetcode;

/**
 * 706. Design HashMap
 * Unit Test
 */
public class TestMyHashMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 MyHashMap obj = new MyHashMap();
		 obj.put(1,20);
		 int param_2 = obj.get(1);
		 System.out.println(param_2);
		 obj.remove(1);
	}

}
