package com.leetcode.bytedance;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author milindeyu
 * @Date 2023/11/29 9:33 下午
 * @Version 1.0
 */
public class Demo2336 {

    class SmallestInfiniteSet {

        TreeSet<Integer> set;
        int threshold;

        public SmallestInfiniteSet() {
            this.set = new TreeSet<>();
            this.threshold = 1;
        }

        public int popSmallest() {
            if (set.isEmpty()) {
                return threshold++;
            }
            return set.pollFirst();
        }

        public void addBack(int num) {
            if (num < threshold) {
                set.add(num);
            }
        }
    }
}
