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
		System.out.print("first");
        L1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
    	L1.await();
    	printSecond.run();
		System.out.print("second");
    	L2.countDown();

    }

    public void third(Runnable printThird) throws InterruptedException {
    	L2.await();
    	printThird.run();
		System.out.print("third");
    }

	public static void main(String[] args) throws InterruptedException {
		Runnable a = new Thread();
		Runnable b = new Thread();
		Runnable c = new Thread();
		Foo4 foo = new Foo4();
		foo.first(b);
		foo.second(c);
		foo.third(a);
	}
}
