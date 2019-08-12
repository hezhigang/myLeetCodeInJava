/**
 * 
 */
package com.leetcode.concurrency.printinorder;

/**
 * @author hezhigang
 * 1114. Print in Order
 * synchronized blocks
 */
public class Foo3 {
	
	private String mutex = new String("");
	private int counter = 1;

	public Foo3() {
		
	}
	
    public void first(Runnable printFirst) throws InterruptedException {
    	boolean loop = true;
    	while (loop) {
    		synchronized(mutex) {
    			if (counter == 1) {
    				printFirst.run();
    				++counter;
    				loop = false;
    			}
    		}
    	}
    }

    public void second(Runnable printSecond) throws InterruptedException {
    	boolean loop = true;
    	while (loop) {
    		synchronized(mutex) {
    			if (counter == 2) {
    				printSecond.run();
    				++counter;
    				loop = false;
    			}
    		}
    	}
    }

    public void third(Runnable printThird) throws InterruptedException {
    	boolean loop = true;
    	while (loop) {
    		synchronized(mutex) {
    			if (counter == 3) {
    				printThird.run();
    				++counter;
    				loop = false;
    			}
    		}
    	}
    }

}
