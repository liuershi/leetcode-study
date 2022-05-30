package com.leetcode.bytedance;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author milindeyu
 * @Date 2022/3/21 11:37 下午
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

        System.out.println("start...");
        readLock.lock();
        System.out.println("start read lock");
        writeLock.lock();
        System.out.println("start write lock");

        TimeUnit.SECONDS.sleep(3);
        System.out.println("over.....");
    }
}
