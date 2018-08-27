/**
 * 作者: 和志刚
 * 日期: 2018年8月23日
 * 时间: 下午12:35:26
 */
package com.leetcode;

import java.util.BitSet;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

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
     * Java 8 Sieve of Eratosthenes
     * https://neilmadden.wordpress.com/2014/01/30/java-8-sieve-of-eratosthenes/
     * @param n
     * @return
     */
    public static int countPrimes2(int n) {
    	final BitSet sieve = new BitSet(n);
    	final IntSummaryStatistics stats = IntStream.rangeClosed(2, n-1)
    	                  .filter(x -> !sieve.get(x))
    	                  .peek(x -> {
    	                      if (x*x < n)
    	                        for(int i = x; i < n; i+=x)
    	                           sieve.set(i);
    	                   })
    	                  .summaryStatistics();
    	System.out.printf("%d %d%n", stats.getCount(), stats.getSum());
    	return new Long(stats.getCount()).intValue();
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
		int i2 = countPrimes2(n);
		System.out.println("counts of primes less than "+ n + " is: "+i);
		System.out.println("counts of primes less than "+ n + " is: "+i2);
	}

}
