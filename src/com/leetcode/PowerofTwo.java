package com.leetcode;

/**
 * 231. Power of Two
 * https://leetcode.com/problems/power-of-two/
 */
public class PowerofTwo {

    public static boolean isPowerOfTwo(int n) {
        for (; n > 0 && ((n & 1) == 0); )
            n = n >>> 1;
        return n == 1;
    }

    /**
     * binary logarithm
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo_logrithm(int n) {
        if (n < 1)
            return false;
        Double logbase2 = Math.log(n) / Math.log(2);
        return logbase2 - logbase2.intValue() <= 0.00000000000001;
    }

    /**
     * bit magic
     * https://leetcode.com/problems/power-of-two/discuss/699658/java-bit-magic
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo_bitmagic(int n) {
        if (n < 1)
            return false;
        return (n & (n - 1)) == 0;
    }

    public static boolean isPowerOfTwo_limit(int n) {
        return n > 0 && 1073741824 % n == 0;
    }

    public static void main(String[] args) {
//        int n = 1;
//        int n = 16;
//        int n = 218;
//        int n = 3;
//        int n = 4;
//        int n = 2;
        int n = 536870912;
//        int n = 0;
        boolean b = isPowerOfTwo(n);
        System.out.printf("%d %s a power of two\n\r", n, b?"is":"is not");
        System.out.println("---------------");
        boolean b2 = isPowerOfTwo_logrithm(n);
        System.out.printf("%d %s a power of two\n\r", n, b2?"is":"is not");
        System.out.println("---------------");
        boolean b3 = isPowerOfTwo_bitmagic(n);
        System.out.printf("%d %s a power of two\n\r", n, b3?"is":"is not");
        int max2power = new Double(Math.pow(2,Math.floor(Math.log(Integer.MAX_VALUE)/Math.log(2)))).intValue();
        System.out.printf("nax 2 power integer=%d\n\r",max2power);
        System.out.println("---------------");
        boolean b4 = isPowerOfTwo_limit(n);
        System.out.printf("%d %s a power of two\n\r", n, b4?"is":"is not");
    }
}
