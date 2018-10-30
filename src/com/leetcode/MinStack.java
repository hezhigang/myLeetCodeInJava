/**
 * 作者: 和志刚
 * 日期: 2018年10月29日
 * 时间: 下午8:19:26
 */
package com.leetcode;

import java.util.Stack;

/**
 * 155. Min Stack
 * http://www.cnblogs.com/grandyang/p/4091064.html
 */
public class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;
	
    /** initialize your data structure here. */
    public MinStack() {
    	stack = new Stack<Integer>();
    	minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
    	stack.push(x);
    	if (minStack.isEmpty() || minStack.peek()>=x)
    		minStack.push(x);
    }
    
    public void pop() {
        int x = stack.pop();
        if (x==minStack.peek())
        	minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());   // Returns -3.
		minStack.pop();
		minStack.top();      // Returns 0.
		System.out.println(minStack.getMin());   // Returns -2.		
	}
}