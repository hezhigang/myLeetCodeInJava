/**
 * 作者: 和志刚
 * 日期: 2018年11月1日
 * 时间: 下午4:39:11
 */
package com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 102. Binary Tree Level Order Traversal
 * https://medium.com/algorithm-problems/binary-tree-level-order-traversal-19f13e260ae5
 */
public class BinaryTreeLevelOrderTraversal {
	
    public static List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (root==null) return result;
    	Map<Integer,List<Integer>> map = new TreeMap<Integer,List<Integer>>();
//    	Map<Integer,List<Integer>> map = new ConcurrentSkipListMap<Integer,List<Integer>>();
		updateMap(root,0,map);
		
    	for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
    		result.add(entry.getValue());
    	}
    	return result;
    }
    
    /**
     * 
     * @param root
     * @param level
     * @param map
     */
    private static void updateMap(TreeNode root, int level, Map<Integer,List<Integer>> map) {
    	if (root == null) return;
    	++level;
    	if (map.containsKey(level)) {
    		map.get(level).add(root.val);
    	}
    	else {
    		List<Integer> list = new ArrayList<Integer>();
    		list.add(root.val);
    		map.put(level, list);
    	}
    	updateMap(root.left,level,map);
    	updateMap(root.right,level,map);
    	return;
    }
    
    /**
     * Ian Bravo Rabay
     * https://leetcode.com/problems/binary-tree-level-order-traversal/discuss/195895/Java-1ms-using-BFS
     * @param root
     * @param level
     * @param map
     */
    public static List<List<Integer>> levelOrder2(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (root!=null) {
    		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
    		queue.add(root);
    		while (!queue.isEmpty()) {
    			int size = queue.size();
    			List<Integer> nodesInLevel = new ArrayList<Integer>();
    			for (int i = 0; i < size; i++) {
    	            TreeNode curr = queue.poll();
    	            nodesInLevel.add(curr.val);
    	            if (curr.left != null) queue.add(curr.left);
    	            if (curr.right != null) queue.add(curr.right);
    	        }
    	        result.add(nodesInLevel);    			
    		}
    	}
    	return result;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode rt = new TreeNode(3);
		
		TreeNode node2Left = new TreeNode(9);
		TreeNode node2Right = new TreeNode(20);
		
		TreeNode node3RightLeft = new TreeNode(15);
		TreeNode node3RightRight = new TreeNode(7);
		
		node2Right.left = node3RightLeft;
		node2Right.right = node3RightRight;
		
		rt.left = node2Left;
		rt.right = node2Right;
		
		List<List<Integer>> list = levelOrder(rt);
		list.forEach(System.out::println);
		System.out.println();
		List<List<Integer>> list2 = levelOrder2(rt);
		list2.forEach(System.out::println);
	}

}
