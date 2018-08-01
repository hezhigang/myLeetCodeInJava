/**
 * 作者: 和志刚
 * 日期: 2018年7月24日
 * 时间: 下午5:08:17
 */
package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 146. LRU Cache
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 */
public class LRUCache {
	private LinkedList<DualLinkNode> list;
	private Map<Integer,DualLinkNode> map;
	private final int cacheSize;
	
    public LRUCache(int capacity) {
    	list = new LinkedList<DualLinkNode>();
    	map = new HashMap<Integer,DualLinkNode>();
    	this.cacheSize = capacity;
    }
    
    public int get(int key) {
    	if (map.containsKey(key)) {
    		DualLinkNode node = map.get(key);
    		list.remove(node);
    		list.addFirst(node);
    		return node.val;
    	}
    	else {
    		return -1;
    	}
    }
    
    public void put(int key, int value) {
    	if (map.containsKey(key)) {
    		DualLinkNode node = map.get(key);
    		list.remove(node);
    		node.val=value;
    		list.addFirst(node);
    	}
    	else {
			if (list.size()==cacheSize) {
				DualLinkNode node = list.pollLast();
				map.remove(node.key);
			}
			DualLinkNode node = new DualLinkNode(key,value);
			list.addFirst(node);
			map.put(key, node);
    	}
    }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LRUCache cache = new LRUCache( 2 /* capacity */ );

//		cache.put(1, 1);
//		cache.put(2, 2);
//		System.out.println( cache.get(1) );       // returns 1
//		cache.put(3, 3);    // evicts key 2
//		System.out.println( cache.get(2) );       // returns -1 (not found)
//		cache.put(4, 4);    // evicts key 1
//		System.out.println( cache.get(1) );       // returns -1 (not found)
//		System.out.println( cache.get(3) );       // returns 3
//		System.out.println( cache.get(4) );       // returns 4
		
		cache.put(2, 1);
		cache.put(2, 2);
		System.out.println( cache.get(2) );
		cache.put(1, 1);
		cache.put(4, 1);
		System.out.println( cache.get(2));
	}
	
	private class DualLinkNode {
		public int key;
		public int val;

		public DualLinkNode(int key, int val) {
			super();
			this.key = key;
			this.val = val;
		}
	}
}
