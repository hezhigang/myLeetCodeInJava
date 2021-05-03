/*
author: hezhigang
date: 5/3/21
time: 3:05 PM
*/
package com.leetcode;

/**
 * 537. Complex Number Multiplication
 * https://leetcode.com/problems/complex-number-multiplication/
 */
public class ComplexNumberMultiplication {

    /**
     * 55 / 55 test cases passed.
     * Runtime: 4 ms, faster than 81.21% of Java online submissions for Complex Number Multiplication.
     * Memory Usage: 37.6 MB, less than 17.58% of Java online submissions for Complex Number Multiplication.
     * @param a
     * @param b
     * @return
     */
    public static String complexNumberMultiply(String a, String b) {
        int re1 = Integer.parseInt(a.substring(0, a.indexOf("+")));
        int im1 = Integer.parseInt(a.substring(a.indexOf("+") + 1, a.length() - 1));
        Complex c1 = new Complex(re1, im1);
        int re2 = Integer.parseInt(b.substring(0, b.indexOf("+")));
        int im2 = Integer.parseInt(b.substring(b.indexOf("+") + 1, b.length() - 1));
        Complex c2 = new Complex(re2, im2);
        Complex c = c1.times(c2);
        return c.toString();
    }

    public static void main(String[] args) {
//        String num1 = "1+1i";
//        String num2 = "1+1i";
        String num1 = "1+-1i";
        String num2 = "1+-1i";
        System.out.printf("%s*%s=%s", num1, num2, complexNumberMultiply(num1, num2));
        System.out.println();
    }

}

class Complex {
    private int re;   // the real part
    private int im;   // the imaginary part

    public Complex(int real, int imag) {
        this.re = real;
        this.im = imag;
    }

    public String toString() {
        return re + "+" + im + "i";
    }

    public Complex times(Complex that) {
        int real = this.re * that.re - this.im * that.im;
        int imag = this.re * that.im + this.im * that.re;
        return new Complex(real, imag);
    }
}
