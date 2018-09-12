/**
 * 作者: 和志刚
 * 日期: 2018年9月10日
 * 时间: 上午11:14:06
 */
package com.leetcode;

/**
 * 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class OptimizedStocks2 {
	
	/**
	 * 
	 * @param prices
	 * @return
	 */
    public static int maxProfit(int[] prices) {
    	int profit = 0;
    	int diff = 0;
    	for(int i=1;i<prices.length;i++) {
    		diff = prices[i]-prices[i-1];
    			if (diff>0) {
    				profit+=diff;
    			}
    	}
        return profit;
    }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] arr = {7,1,5,3,6,4};
//		 int[] arr = {1,2,3,4,5};
		 int[] arr = {7,6,4,3,1};
		System.out.println( maxProfit(arr) );
	}

}
