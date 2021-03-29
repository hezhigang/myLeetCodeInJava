/**
 * 
 */
package com.leetcode.concurrency.printinorder;

import java.util.concurrent.Semaphore;

/**
 * @author hezhigang
 * 1114. Print in Order
 * Semaphore
 *
 */
public class Foo2 {
	Semaphore semaphore1 = new Semaphore(0);
	Semaphore semaphore2 = new Semaphore(0);

	public Foo2() {
	}

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
		System.out.print("first");
        semaphore1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
    	semaphore1.acquire();
    	printSecond.run();
		System.out.print("second");
    	semaphore2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
    	semaphore2.acquire();
    	printThird.run();
		System.out.print("third");
    }

	public static void main(String[] args) throws InterruptedException {
		Runnable a = new Thread();
		Runnable b = new Thread();
		Runnable c = new Thread();
		Foo2 foo = new Foo2();
		foo.first(c);
		foo.second(a);
		foo.third(b);
	}
}
