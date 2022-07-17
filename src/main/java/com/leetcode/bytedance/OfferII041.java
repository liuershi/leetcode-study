package com.leetcode.bytedance;


/**
 * @Author milindeyu
 * @Date 2022/7/16 12:17 上午
 * @Version 1.0
 */
public class OfferII041 {

    class MovingAverage {

        int[] windows;
        // 元素个数和当前滑动窗口内元素和
        int elementSize, sum;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            windows = new int[size];
        }

        public double next(int val) {
            elementSize++;
            sum += val;

            int oldPos = (elementSize - 1) % windows.length;
            if (elementSize > windows.length) sum -= windows[oldPos];

            windows[oldPos] = val;
            return (double) sum / Math.min(elementSize, windows.length);
        }
    }
}
