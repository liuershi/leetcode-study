package com.leetcode.weekly.yinlian.week293;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeSet;

/**
 * @Author milindeyu
 * @Date 2022/8/10 11:09 下午
 * @Version 1.0
 */
public class Demo2276 {

    /**
     * 基于区间合并实现
     */
     static class CountIntervals {

        TreeSet<int[]> container;

        Comparator<int[]> comparator;

        int count = 0;

        public CountIntervals() {
            this.comparator = new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o2[0] > o1[1]) return 1;
                    else if (o1[0] > o2[1]) return -1;
                    else return 0;
                }
            };
            this.container = new TreeSet<>(comparator);
        }

        public void add(int left, int right) {
            int[] range = {left, right};
            if (!container.add(range)) {
                int[] floor;
                int[] cur = range;
                while ((floor = container.floor(range)) != null && comparator.compare(floor, range) == 0) {
                    cur = new int[]{Math.min(floor[0], cur[0]), Math.max(floor[1], cur[1])};
                    container.remove(floor);
                    count -= floor[1] - floor[0] + 1;
                }
                container.add(cur);
                count += cur[1] - cur[0] + 1;
            } else {
                count += right - left + 1;
            }
        }

        public int count() {
            return count;
        }
    }

}
