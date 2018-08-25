/**
 * 作者: 和志刚
 * 日期: 2018年8月24日
 * 时间: 下午11:10:40
 */
package com.leetcode;

/**
 * 371. Sum of Two Integers
 */
public class SumOfTwoIntegers {
	/**
	 * https://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/
	 * @param a
	 * @param b
	 * @return
	 */
    public static int getSum(int a, int b) {
    	// Iterate till there is no carry
    	while (b!=0) {
    		// carry now contains common set bits of x and y
    		int carry = a&b;
    		// Sum of bits of x and y where at least one of the bits is not set
    		a = a^b;
    		// Carry is shifted by one so that adding it to x gives the required sum
    		b = carry<<1;
    	}
        return a;
    }
    
    /**
     * https://www.quora.com/How-do-I-add-two-numbers-without-using-any-operator-C-C++
     * @param a
     * @param b
     * @return
     */
    public static int getSum2(int a, int b) {
    	int sum,carry;
    	if (b==0) return a;
    	sum = a ^ b; // add without carrying
        carry = (a & b) << 1; // carry, but don’t add
        return getSum2(sum,carry); // recurse    	
    }
    
    /**
     * https://www.quora.com/How-do-I-add-two-numbers-without-using-any-operator-C-C++
     * @param a
     * @param b
     * @return
     */
    public static int getSum3(int a, int b) {
    	if (a>0) {
    		while(a>0) {
    			a--;
    			b++;
    		}
    	}
    	if (a<0) {
    		while(a<0) {
    			a++;
    			b--;
    		}
    	}
    	return b;
    }    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int c = getSum(a,b);
		int d = getSum2(a,b);
		int e = getSum3(a,b);
		System.out.println(a+"+"+b+"="+c);
		System.out.println(a+"+"+b+"="+d);
		System.out.println(a+"+"+b+"="+e);
	}

}
