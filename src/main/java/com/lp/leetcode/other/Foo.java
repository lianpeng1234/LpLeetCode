package com.lp.leetcode.other;

import java.util.concurrent.atomic.AtomicInteger;

class Foo {

    public static AtomicInteger atomicInteger = new AtomicInteger(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (true) {
            if (atomicInteger.compareAndSet(0, 1)) {
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                break;
            }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (true) {
            if (atomicInteger.compareAndSet(1, 2)) {
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                break;
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (true) {
            if (atomicInteger.compareAndSet(2, 0)) {
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                break;
            }
        }
    }
}


