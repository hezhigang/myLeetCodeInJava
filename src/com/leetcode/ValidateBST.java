/**
 * 作者: 和志刚
 * 日期: 2018年11月3日
 * 时间: 上午7:57:41
 */
package com.leetcode;

/**
 * 98. Validate Binary Search Tree
 */
public class ValidateBST {
	
    public static boolean isValidBST(TreeNode root) {
    	return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    /**
     * https://en.wikipedia.org/wiki/Binary_search_tree
     * @param root
     * @param minKey
     * @param maxKey
     * @return
     */
    public static boolean isValidBST(TreeNode root, long minKey, long maxKey) {
    	if (root==null) return true;
    	if (root.val<=minKey || root.val>=maxKey) return false;
    	return isValidBST(root.left,minKey,root.val) && isValidBST(root.right,root.val,maxKey);
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//TestCase 1
//		TreeNode rt = new TreeNode(2);
//		TreeNode leaf_L = new TreeNode(1);
//		TreeNode leaf_R = new TreeNode(3);
//		rt.left=leaf_L;
//		rt.right=leaf_R;
		
		//TestCase 2
//		TreeNode rt = new TreeNode(5);
//		TreeNode leaf_L = new TreeNode(1);
//		rt.left=leaf_L;
//		TreeNode right_tree_rt = new TreeNode(4);
//		TreeNode right_tree_leaf_L = new TreeNode(3);
//		right_tree_rt.left=right_tree_leaf_L;
//		TreeNode right_tree_leaf_R = new TreeNode(6);
//		right_tree_rt.right=right_tree_leaf_R;
//		rt.right=right_tree_rt;
		
		//TestCase 3
//		TreeNode rt = new TreeNode(1);
//		TreeNode leaf = new TreeNode(1);
//		rt.left=leaf;
		
//		TestCase 4
//		TreeNode rt = new TreeNode(1);
//		TreeNode leaf = new TreeNode(1);
//		rt.right=leaf;
		
		//TestCase 5
//		TreeNode rt = new TreeNode(-2147483648);
//		TreeNode leaf = new TreeNode(-2147483648);
//		rt.left=leaf;
		
		//TestCase 6
		TreeNode rt = new TreeNode(2147483647);
		
		System.out.println((isValidBST(rt)?"is":"is not")+" Binary Search Tree");
	}

}
