package com.leetcode;

/**
 *
 */
public class PowerofFour {

    public static boolean isPowerOfFour(int num) {
        for (; num > 0 && num % 4 == 0; )
            num = num >>> 2;
        return num == 1;
    }

    public static boolean isPowerOfFour_logrithm(int num) {
        if (num < 1)
            return false;
        Double logbase4 = Math.log(num) / Math.log(4);
        return logbase4 - logbase4.intValue() <= 0.00000000000001;
    }

    /**
     * https://www.techiedelight.com/check-given-number-power-of-4/
     * @param num
     * @return
     */
    public static boolean isPowerOfFour_bitmagic_1(int num) {
        return num != 0 && (num & (num - 1)) == 0 && (num & 0xAAAAAAAA) == 0;
    }

    /**
     * https://www.techiedelight.com/check-given-number-power-of-4/
     * @param num
     * @return
     */
    public static boolean isPowerOfFour_bitmagic_2(int num) {
        return ((num & (num - 1)) == 0) && (num % 3 == 1);
    }

    public static void main(String[] args) {
//        System.out.printf("the max power of four in java signed 32 bits integer = %d\n\r",
//                new Double(Math.pow(4, 15)).intValue());
//        int num = 4;
//        int num = 5;
//        int num = 2;
//        int num = 8;
//        int num = 1;
        int num = 16;
        boolean b = isPowerOfFour(num);
        System.out.printf("%d %s power of 4\n\r", num, b ? "is" : "is not");
        System.out.println("---------------");
        boolean b2 = isPowerOfFour_logrithm(num);
        System.out.printf("%d %s power of 4\n\r", num, b2 ? "is" : "is not");
        System.out.println("---------------");
        boolean b3 = isPowerOfFour_bitmagic_1(num);
        System.out.printf("%d %s power of 4\n\r", num, b3 ? "is" : "is not");
        System.out.println("---------------");
        boolean b4 = isPowerOfFour_bitmagic_2(num);
        System.out.printf("%d %s power of 4\n\r", num, b4 ? "is" : "is not");
    }
}
