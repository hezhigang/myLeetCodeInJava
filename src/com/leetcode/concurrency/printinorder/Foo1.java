/**
 * 
 */
package com.leetcode.concurrency.printinorder;

/**
 * @author hezhigang
 * 1114. Print in Order
 * volatile
 */
public class Foo1 {
	
	private volatile int flag;

    public Foo1() {
        flag = 1;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        for(;;) {
        	if (flag==1) {
        		printFirst.run();
        		System.out.print("first");
        	}
        	flag = 2;
        	break;
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
    	for(;;) {
    		if (flag==2) {
    			printSecond.run();
    			System.out.print("second");
    		}
    		flag=3;
    		break;
    	}
    }

    public void third(Runnable printThird) throws InterruptedException {
    	for(;;) {
    		if (flag==3) {
    			printThird.run();
    			System.out.print("third");
    		}
    		flag = 1;
    		break;
    	}
    }
}