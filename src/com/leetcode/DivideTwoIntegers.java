/**
 * 作者: 和志刚
 * 日期: 2018年10月30日
 * 时间: 上午11:05:12
 */
package com.leetcode;

/**
 * 29. Divide Two Integers
 */
public class DivideTwoIntegers {
	
	/**
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
    public static int divide(int dividend, int divisor) {
		if (divisor == 0)
			return Integer.MAX_VALUE;
		if (divisor == -1 && dividend == Integer.MIN_VALUE)
			return Integer.MAX_VALUE;
		
    	boolean sign = ((new Long(dividend)>0) && (new Long(divisor)>0)) || ((new Long(dividend)<0) && (new Long(divisor)<0)) ? true : false;
    	
    	long dividend_abs = Math.abs(new Long(dividend));
    	long divisor_abs = Math.abs(new Long(divisor));

    	long quotient = 0;
		while (dividend_abs >= divisor_abs) {
			// calculate number of left shifts
			int numShift = 0;
			while (dividend_abs >= (divisor_abs << numShift)) {
				numShift++;
			}
			// dividend minus the largest shifted divisor
			quotient += 1 << (numShift - 1);
			dividend_abs -= (divisor_abs << (numShift - 1));
		}
    	
    	return sign?new Long(quotient).intValue():-new Long(quotient).intValue();       
    }	
	
	/**
	 * https://www.programcreek.com/2014/05/leetcode-divide-two-integers-java/
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public static int divide_programcreek(int dividend, int divisor) {
		// handle special cases
		if (divisor == 0)
			return Integer.MAX_VALUE;
		if (divisor == -1 && dividend == Integer.MIN_VALUE)
			return Integer.MAX_VALUE;

		// get positive values
		long pDividend = Math.abs((long) dividend);
		long pDivisor = Math.abs((long) divisor);

		int result = 0;
		while (pDividend >= pDivisor) {
			// calculate number of left shifts
			int numShift = 0;
			while (pDividend >= (pDivisor << numShift)) {
				numShift++;
			}

			// dividend minus the largest shifted divisor
			result += 1 << (numShift - 1);
			pDividend -= (pDivisor << (numShift - 1));
		}

		if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
			return result;
		} else {
			return -result;
		}
	}		
	
	/**
	 * https://www.geeksforgeeks.org/divide-two-integers-without-using-multiplication-division-mod-operator/
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public static int divide_bug(int dividend, int divisor) {
		boolean sign = ((new Long(dividend)>0) && (new Long(divisor)>0)) || ((new Long(dividend)<0) && (new Long(divisor)<0)) ? true : false;
    	System.out.println("sign="+sign);
    	long dividend_abs = Math.abs(new Long(dividend));
    	System.out.println("dividend_abs="+dividend_abs);
    	long divisor_abs = Math.abs(new Long(divisor));
    	System.out.println("divisor_abs="+divisor_abs);
    	
    	long quotient = 0, temp = 0;
		for (int i = 31; i >= 0; --i) {
			if (temp + (divisor_abs << i) <= dividend_abs) {
				temp += divisor_abs << i;
				quotient |= 1 << i;
			}
		}
    	System.out.println("quotient="+quotient);
    	if (quotient>Integer.MAX_VALUE || quotient<Integer.MIN_VALUE)
    		quotient = Integer.MAX_VALUE;
    	return sign?new Long(quotient).intValue():-new Long(quotient).intValue();		
	}

	public static int add(int a, int b) {
		int partialSum, carry;
		do {
			partialSum = a ^ b;
			carry = (a & b) << 1;
			a = partialSum;
			b = carry;
		} while (carry != 0);
		return partialSum;
	}

	public static int subtract(int a, int b) {
		return add(a, add(~b, 1));
	}	
	
	/**
	 * https://www.quora.com/How-do-I-divide-two-numbers-using-only-bit-operations-in-Java
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public static int divide_quora(int dividend, int divisor) {
        boolean negative = false;
        if ((dividend & (1 << 31)) == (1 << 31)) { // Check for signed bit
            negative = !negative;
            dividend = add(~dividend, 1);  // Negation
        }
        if ((divisor & (1 << 31)) == (1 << 31)) {
            negative = !negative;
            divisor = add(~divisor, 1);  // Negation
        }
        int quotient = 0;
        long r;
        for (int i = 30; i >= 0; i = subtract(i, 1)) {
            r = (divisor << i);
           // Left shift divisor until it's smaller than dividend
            if (r < Integer.MAX_VALUE && r >= 0) { // Avoid cases where comparison between long and int doesn't make sense
                if (r <= dividend) { 
                    quotient |= (1 << i);    
                    dividend = subtract(dividend, (int) r);
                }
            }
        }
        if (negative) {
            quotient = add(~quotient, 1);
        }
        return quotient;
	}
	
	/**
	 * 11 / 989 test cases passed.
	 * Status: Time Limit Exceeded
	 * @param dividend
	 * @param divisor
	 * @return
	 */
    public static int divide_naive(int dividend, int divisor) {
    	boolean flag = ((new Long(dividend)>0) && (new Long(divisor)>0)) || ((new Long(dividend)<0) && (new Long(divisor)<0)) ? true : false;
//    	System.out.println("flag="+flag);
    	long r = 0;
    	long dividend_abs = Math.abs(new Long(dividend));
//    	System.out.println("dividend_abs="+dividend_abs);
    	long divisor_abs = Math.abs(new Long(divisor));
    	while(dividend_abs>=divisor_abs) {
    		dividend_abs-=divisor_abs;
    		++r;
    	}
//    	System.out.println("r="+r);
    	if (r>Integer.MAX_VALUE || r<Integer.MIN_VALUE)
    		r = Integer.MAX_VALUE;
    	return flag?new Long(r).intValue():-new Long(r).intValue();
    }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int dividend = 10;
//		int divisor = 3;
		
//		int dividend = 7;
//		int divisor = -3;		
		
//		int dividend = 1;
//		int divisor = 1;
		
//		int dividend = -2147483648;
//		int divisor = -1;
		
		int dividend = 2147483647;
		int divisor = 1;
		
		int quotient = divide(dividend,divisor);
		System.out.printf("%d/%d=%d", dividend, divisor, quotient);
	}

}