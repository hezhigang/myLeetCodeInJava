/**
 * 作者: 和志刚
 * 日期: 2018年9月26日
 * 时间: 上午11:52:46
 */
package com.leetcode;

import java.util.Arrays;

/**
 * 518. Coin Change 2
 */
public class CoinChange2 {
	
	/**
	 * Recursive Solution
	 * @param amount
	 * @param coins
	 * @return
	 */
    public static int change_Recursive(int amount, int[] coins) {
    	if (amount<0) return 0;
    	if (amount==0) return 1;
    	if (amount>0 && coins.length<=0) return 0;
    	int m = coins.length;
    	return change_Recursive(amount,Arrays.copyOf(coins, m-1))+change_Recursive(amount-coins[m-1],coins);
    }	

    /**
     * 
     * @param amount
     * @param coins
     * @return
     */
    public static int change(int amount, int[] coins) {
    	int[] dp = new int[amount+1];
    	dp[0]=1;
    	for(int i=0;i<coins.length;i++) {
    		for(int j=coins[i];j<=amount;++j) {
    			dp[j]+=dp[j-coins[i]];
    		}    		
    	}
    	return dp[amount];
    }  
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int amount=5;
//		int[] coins={1,2,5};
		
//		int amount=3;
//		int[] coins={2};	
		
//		int amount=10;
//		int[] coins={10};
		
//		int amount = 4;
//		int[] coins = {1,2,3};
		
//		int amount = 10;
//		int[] coins = {2, 5, 3, 6};
		
		int amount = 500;
		int[] coins = {3,5,7,8,9,10,11};		
		
//		int cc = change_Recursive(amount,coins);
		int cc = change(amount,coins);
		System.out.println("the number of combinations for "+amount+" by coins "+Arrays.toString(coins)+"="+cc);
	}

}
