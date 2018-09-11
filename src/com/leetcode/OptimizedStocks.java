/**
 * 作者: 和志刚
 * 日期: 2018年9月6日
 * 时间: 下午9:43:19
 */
package com.leetcode;

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class OptimizedStocks {
	    
    public static int maxProfit(int[] prices) {
    	if (prices==null || prices.length==0)
    		return 0;
        int r = 0;
        for(int i=0;i<prices.length-1;i++) {
        	for(int j=prices.length-1;j>i;j--) {
        		if (prices[j]-prices[i]>r) {
        			r = prices[j]-prices[i];
        		}
        	}
        }
        return r;
    } 
    
    /**
     * https://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-java/
     * Instead of keeping track of largest element in the array, we track the maximum profit so far.
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
    	if (prices==null || prices.length<=1)
    		return 0;
        int r = 0;
        int minPrice = prices[0];
        for(int i=1;i<prices.length;i++) {
        	r = Math.max(r, prices[i]-minPrice);
        	minPrice = Math.min(minPrice, prices[i]);
        }
        return r;
    }    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] arr = {};
//		int[] arr = {7,1,5,3,6,4};
//		int[] arr = {7,6,4,3,1};
		int[] arr = {2,4,1};
//		int[] arr = {3,2,6,5,0,3};
		System.out.println( maxProfit(arr) );
		System.out.println( maxProfit2(arr) );
	}

	/**
	 * 
	 * @param prices
	 * @return
	 */
    public static int maxProfit_Logical_bug(int[] prices) {
    	if (prices==null || prices.length==0)
    		return 0;
        int r = 0;
        int minPrice = prices[0];
        int minIdx = 0;
        for(int i=1;i<prices.length-1;i++) {
        	if (prices[i]<minPrice) {
        		minPrice = prices[i];
        	    minIdx = i;        		
        	}
        }
        int maxPrice = prices[minIdx];
        for(int i=minIdx+1;i<prices.length;i++) {
        	if (prices[i]>maxPrice)
        		maxPrice = prices[i];
        }
        r = maxPrice-minPrice;
        return r;
    }	
}
