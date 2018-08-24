/**
 * 作者: 和志刚
 * 日期: 2018年8月23日
 * 时间: 下午12:35:26
 */
package com.leetcode;

/**
 * 204. Count Primes
 * http://rosettacode.org/wiki/Primality_by_trial_division#Java
 */
public class CountPrimes {
	
    public static int countPrimes(int n) {
    	if (n<=2) return 0;
        int x = 0;
        int sqrt = (int) Math.sqrt(n);
        System.out.println("sqrt="+sqrt);
        boolean[] b = new boolean[n];
        b[0]=b[1]=false;
        for(int i=2;i<n;i++)
        	b[i]=true;
        for(int i=2;i<=sqrt;i++) {
        	if (b[i]) {
            	for(int j=i*i;j<n;j+=i) {
            		b[j]=false;
            	}        		
        	}
        }
        for(int i=0;i<b.length;i++) {
        	if (b[i])
        		x++;
        }
        return x;
    }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int n = 0;
//		int n = 2;
//		int n = 3;
//		int n = 1;
//		int n = 10;
//		int n = 100;
		int n = 999983;
		int i = countPrimes(n);
		System.out.println("counts of primes less than "+ n + " is: "+i);
	}

}
