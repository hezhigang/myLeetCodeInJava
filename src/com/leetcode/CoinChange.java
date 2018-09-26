/**
 * 作者: 和志刚
 * 日期: 2018年9月14日
 * 时间: 下午11:53:13
 */
package com.leetcode;

/**
 * 322. Coin Change
 */
public class CoinChange {
	
	/**
	 * recursive
	 * @param coins
	 * @param amount
	 * @return
	 */
    public static int coinChange_recursive(int[] coins, int amount) {
    	if (amount==0) return 0;
        int n = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++) {
        	if (amount>=coins[i]) {
        		int numCoins = coinChange_recursive(coins,amount-coins[i]);
          	  if ( numCoins!=Integer.MAX_VALUE && (numCoins+1<n) )
          		  n = numCoins+1;        		
        	}
        }
        if (n==Integer.MIN_VALUE || n==Integer.MAX_VALUE || n==0) n = -1;
        return n;
    }
    
    /**
     * Dynamic Programming
     * Bottom-Up
     * https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
    	if (amount==0) return 0;
    	
    	int n=-1;
    	
    	int[] MC = new int[amount+1];
    	MC[0]=0;
    	for(int i=1;i<=amount;i++) {
    		MC[i] = Integer.MAX_VALUE;
    	}
    	
    	for(int i=1;i<=amount;i++) {
    		for(int j=0;j<coins.length;j++) {
    			if (i>=coins[j]) {
    				int numCoins = MC[i-coins[j]];
    				if (numCoins!=Integer.MAX_VALUE && (numCoins+1<MC[i])) {
    					MC[i] = numCoins+1;
    				}
    			}
    		}
    	}
    	n=MC[amount];
    	
    	if (n==Integer.MIN_VALUE || n==Integer.MAX_VALUE || n==0) n = -1;
    	return n;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(Integer.MIN_VALUE);
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.MAX_VALUE+1);
		
//		int[] coins = {1, 2, 5};
//		int amount = 11;
		
//		int[] coins = {2};
//		int amount = 3;
		
//		int[] coins = {2};
//		int amount = 1;
		
//		int[] coins = {1,2,5};
//		int amount = 100;
		
		int[] coins = {1};
		int amount = 0;
		
		int n = coinChange(coins,amount);
		System.out.println("the fewest number of coins for " + amount + " is: "+n);		
	}

}