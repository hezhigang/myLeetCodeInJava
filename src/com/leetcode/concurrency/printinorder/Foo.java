/**
 * 
 */
package com.leetcode.concurrency.printinorder;

import java.util.concurrent.Phaser;

/**
 * @author hezhigang
 * 1114. Print in Order
 * Phaser
 */
public class Foo {

	private Phaser phaser;

	public Foo() {
//		phaser = new Phaser(3);
		phaser = new Phaser(1);
	}

	public void first(Runnable printFirst) throws InterruptedException {
		phaser.arrive();
		phaser.awaitAdvance(0);
        printFirst.run();
		System.out.print("first");
		phaser.arrive();
		phaser.arrive();
    }

    public void second(Runnable printSecond) throws InterruptedException {
		phaser.arrive();
		phaser.awaitAdvance(0);
		phaser.arrive();
		phaser.awaitAdvance(1);
    	printSecond.run();
		System.out.print("second");
		phaser.arrive();
    }

    public void third(Runnable printThird) throws InterruptedException {
		phaser.arrive();
		phaser.awaitAdvance(0);
		phaser.arrive();
		phaser.awaitAdvance(1);
		phaser.arrive();
		phaser.awaitAdvance(2);
    	printThird.run();
		System.out.print("third");
    }

	public static void main(String[] args) throws InterruptedException {
		Runnable a = new Thread();
		Runnable b = new Thread();
		Runnable c = new Thread();
		Foo foo = new Foo();
		foo.first(a);
		foo.second(b);
		foo.third(c);
	}
}