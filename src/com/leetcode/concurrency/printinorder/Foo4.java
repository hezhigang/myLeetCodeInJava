/**
 * 
 */
package com.leetcode.concurrency.printinorder;

import java.util.concurrent.CountDownLatch;

/**
 * @author hezhigang
 * 1114. Print in Order
 * CountDownLatch
 */
public class Foo4 {
	private final CountDownLatch L1 = new CountDownLatch(1);
	private final CountDownLatch L2 = new CountDownLatch(1);

	public Foo4() {
	}

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        L1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
    	L1.await();
    	printSecond.run();
    	L2.countDown();

    }

    public void third(Runnable printThird) throws InterruptedException {
    	L2.await();
    	printThird.run();
    }
}
