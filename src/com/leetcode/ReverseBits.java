/**
 * 作者: 和志刚
 * 日期: 2018年10月26日
 * 时间: 下午11:14:39
 */
package com.leetcode;

/**
 * 190. Reverse Bits
 * If this function is called many times, how would you optimize it?
 */
public class ReverseBits {
	
	// you need treat n as an unsigned value
	public static int reverseBits(int n) {
		/**
		 * 190. Reverse Bits
		 * https://www.cnblogs.com/yrbbest/p/4491661.html
		 * n = 10,11返回结果不对，但LeetCode上却通过了，不解?
		 */
		int res = 0;
		for (int i = 31; i >= 0; i--) {
			if (((n >> i) & 1) == 1) {
				res += (1 << (31 - i));
			}
		}
		return res;
	}	
	
	// you need treat n as an unsigned value
	public static int reverseBits9(int n) {
		long x = n;
		long result = 0;
		for(int i=0;i<32;i++) {
			result = (result << 1) | (x & 1);
			if (x>0)
			  x = (x >>> 1);
		}
		return new Long(result).intValue();
	}	
	
	public static int reverseBits8(int n) {
        int reverse = 0;
        for (int i = 0; i < 31; i++) {
            reverse = (n & 1) | reverse;
            reverse = reverse << 1;
            n = n >> 1;
        }
        reverse = (n & 1) | reverse;
        return reverse;
    }
	
	// you need treat n as an unsigned value
	public static int reverseBits7(int n) {
		int left = 0;
		int right = 31;
		while (left < right) {
			// swap bit
			int x = (n >> left) & 1;
			int y = (n >> right) & 1;

			if (x != y) {
				n ^= (1 << left) | (1 << right);
			}
			++left;
			--right;
		}
		return n;
	}	
	
	// you need treat n as an unsigned value
	public static int reverseBits6(int n) {
		int result = 0;
		for (int i = 0; i < 32; ++i) {
			if ((n & 1) == 1) {
				result = (result << 1) + 1;
			} else {
				result = result << 1;
			}
			n = n >> 1;
		}
		return result;
	}	
	
    // you need treat n as an unsigned value
    public static int reverseBits1(int n) {
    	long r=0;
    	while(n>0) {
//    	for(int i=0;i<32;i++) {
    		r <<= 1;
    		if ((int)(n & 1)==1)
    			r ^= 1;
//    		n >>= 1;
    		n >>>= 1;
    	}
    	return new Long(r).intValue();
    }
    
	public static int reverseBits2(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result ^= n & 1;
			n >>>= 1;  //必须进行无符号位移
			if (i < 31)  //最后一次不需要进行位移
				result <<= 1;
		}
		return result;
	}
	
	public static long reverseBits3(long n) {
		long rev = 0;
		for (int i = 0; i < 32; i++) {
			rev <<= 1;
			if ((n & (1 << i)) != 0)
				rev |= 1;
		}
		return rev;
	}
	
	public static int reverseBits4(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result = (result << 1) | (n & 1);
			n = (n >>> 1);
		}
		return result;
	}
	
	public static int reverseBits5(int n) {
		for (int i = 0; i < 16; i++) {
			n = swapBits(n, i, 32 - i - 1);
		}
	 
		return n;
	}	
	
	public static int swapBits(int n, int i, int j) {
		int a = (n >> i) & 1;
		int b = (n >> j) & 1;
		if ((a ^ b) != 0) {
			return n ^= (1 << i) | (1 << j);
		}
		return n;
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int n = 43261596;
//		int n=11;
		int n=10;
		int r = reverseBits(n);
		int r2 = reverseBits2(n);
		int r3 = reverseBits5(n);
		
		System.out.printf("Reverse bits of %d=%d", n,r);
		System.out.println("");
		System.out.printf("Reverse bits of %d=%d", n,r2);
		System.out.println("");
		System.out.printf("Reverse bits of %d=%d", n,r3);
	}

}
