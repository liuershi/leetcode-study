package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2024/1/6 10:02 下午
 * @Version 1.0
 */
public class Demo1114 {

    class Foo {

        volatile int val;

        public Foo() {
            this.val = 0;
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            synchronized (this) {
                while (val != 0) {
                    wait();
                }
                printFirst.run();
                val = 1;
                notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            synchronized (this) {
                while (val != 1) {
                    wait();
                }
                printSecond.run();
                val = 2;
                notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            synchronized (this) {
                while (val != 2) {
                    wait();
                }
                printThird.run();
                val = 0;
                notifyAll();
            }
        }
    }
}
