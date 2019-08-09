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
        semaphore1.release();

    }

    public void second(Runnable printSecond) throws InterruptedException {
    	semaphore1.acquire();
    	printSecond.run();
    	semaphore2.release();

    }

    public void third(Runnable printThird) throws InterruptedException {
    	semaphore2.acquire();
    	printThird.run();
    }	
}
