/**
 * 作者: 和志刚
 * 日期: 2018年10月12日
 * 时间: 下午4:02:08
 */
package com.leetcode;

import java.util.Stack;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 */
public class BTreeFromPreAndInTraversal {
	
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
    	int preStart=0;
    	int preEnd=preorder.length-1;
    	int inStart = 0;
    	int inEnd = inorder.length-1;
        return buildTree(preorder,preStart,preEnd,inorder,inStart,inEnd);
    }
    
    public static TreeNode buildTree(int[] preorder, int preStart,int preEnd, int[] inorder, int inStart, int inEnd) {
    	if (preStart>preEnd || inStart>inEnd)
    	  return null;
    	
    	int val = preorder[preStart];
    	TreeNode rt = new TreeNode(val);
    	
    	int k=0;
    	for(int i=0;i<=inEnd;i++) {
    		if (inorder[i]==val) {
    			k=i;
    			break;
    		}
    	}
    	
    	rt.left = buildTree(preorder, preStart+1, preStart+(k-inStart),inorder,inStart,k-1);
    	rt.right = buildTree(preorder, preStart+(k-inStart)+1, preEnd, inorder, k+1, inEnd);
    	
    	return rt;
    }
    
	 private static TreeNode getParent(TreeNode rt, TreeNode current) {
		 TreeNode temp;
		if (rt == null) return null;
		if (rt.left == current || rt.right == current) return rt;
		if ( (temp=getParent(rt.left,current))!=null )
			return temp;
		else
			return getParent(rt.right, current);
	}	
    
	/**
	 * 缩进字符图示
	 * @param rt
	 */
	public static void indent(TreeNode rt) {
		if (rt==null) return;
		TreeNode ptr = rt;
		TreeNode tmpNode = null;
		int level = 0;
		Stack stk = new Stack();
		while(!stk.isEmpty() || ptr != null) {
			if (ptr!=null) {
				tmpNode = ptr;
				level = 0;
				while(tmpNode!=null)
				{
					tmpNode = getParent(rt,tmpNode);
					level++;
				}
					
				printNodeMsg(--level, ptr);
				stk.push(ptr);
				ptr = ptr.left;
			}
			else {
				ptr = (TreeNode) stk.peek();
				ptr = ptr.right;
				stk.pop();
			}
			
		}
	}
	
	private static void printNodeMsg(int level, TreeNode node) {
		while(level>0)
		{
			System.out.print(".");
			level--;
		}
		System.out.print(node.val);
		System.out.print("\n");
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] preorder = {3,9,20,15,7};
//		int[] inorder = {9,3,15,20,7};
		
		int[] inorder = {4,2,5,1,6,7,3,8};
		int[] preorder = {1,2,4,5,3,7,6,8};
		
		TreeNode treenode = buildTree(preorder,inorder);
		indent(treenode);
	}

}
