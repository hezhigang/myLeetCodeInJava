/**
 * 作者: 和志刚
 * 日期: 2018年10月15日
 * 时间: 上午1:46:09
 */
package com.leetcode;

import java.util.Stack;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */
public class BTreeFromInAndPostTraversal {
	
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
    	int inStart=0;
    	int inEnd=inorder.length-1;
    	int postStart=0;
    	int postEnd=postorder.length-1;
        return buildTree(inorder,inStart,inEnd,postorder,postStart,postEnd);
    }
    
    public static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
    	if (inStart>inEnd || postStart>postEnd)
    		return null;
    	
    	int rtVal = postorder[postEnd];
    	TreeNode rt = new TreeNode(rtVal);
    	
//    	int k=Arrays.binarySearch(inorder, rtVal);
    	int k=0;
    	for(int i=0;i<=inEnd;i++) {
    		if (inorder[i]==rtVal) {
    			k=i;
    			break;
    		}
    	}
    	
    	rt.left = buildTree(inorder,inStart,k-1,postorder, postStart, postStart+k-inStart-1);
    	rt.right = buildTree(inorder,k+1,inEnd,postorder,postStart+k-inStart,postEnd-1);
    	
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
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		
//		int[] inorder = {4,2,5,1,6,7,3,8};
//		int[] postorder = {4,5,2,6,7,8,3,1};
		
		TreeNode treenode = buildTree(inorder,postorder);
		indent(treenode);		
	}

}
