/**
 * 作者: 和志刚
 * 日期: 2019年2月12日
 * 时间: 下午8:40:28
 */
package com.leetcode;

/**
 * 326. Power of Three
 */
public class PowerOfThree {

	/**
	 * https://leetcode.com/problems/power-of-three/discuss/235907/Java-Solutions
	 * @param n
	 * @return
	 */
    public static boolean isPowerOfThree(int n) {
    	return n>0 && 1162261467%n==0?true:false;
    }
    
    /**
     * https://leetcode.com/problems/power-of-three/discuss/192930/Java-No-LoopRecursion-(Using-Logarithm)
     * @param n
     * @return
     */
    public static boolean isPowerOfThree2(int n) {
    	if (n<=0) return false; 
    	double power = Math.log10(n)/Math.log10(3);
    	return power==Math.ceil(power)?true:false;
    }    
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.printf("%d^%d=%f", 3, 19, Math.pow(3, 19));
		System.out.println();
		System.out.printf("%d %s a power of three",27,isPowerOfThree2(27)?"is":"is not");
		System.out.println();
		System.out.printf("%d %s a power of three",0,isPowerOfThree2(0)?"is":"is not");
		System.out.println();
		System.out.printf("%d %s a power of three",9,isPowerOfThree(9)?"is":"is not");
		System.out.println();
		System.out.printf("%d %s a power of three",45,isPowerOfThree(45)?"is":"is not");
	}

}
