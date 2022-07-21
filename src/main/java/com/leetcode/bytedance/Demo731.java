package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @Author milindeyu
 * @Date 2022/7/19 9:32 下午
 * @Version 1.0
 */
public class Demo731 {

    class MyCalendarTwo {

        List<int[]> oneContainer;
        List<int[]> secContainer;

        public MyCalendarTwo() {
            oneContainer = new ArrayList<>();
            secContainer = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] calendar : secContainer) {
                int left = calendar[0], right = calendar[1];
                if (end > left && start < right) return false;
            }

            for (int[] calendar : oneContainer) {
                int left = calendar[0], right = calendar[1];
                if (end > left && start < right) secContainer.add(new int[]{Math.max(left, start), Math.min(right, end)});
            }
            oneContainer.add(new int[]{start, end});
            return true;
        }
    }


    /**
     * 通过分差数组实现
     */
    class MyCalendarTwo2 {

        /**
         * 该map存储的为 start ==> 1 和 end ==> -1
         */
        TreeMap<Integer, Integer> booked;

        public MyCalendarTwo2() {
            // 默认已经排序，使用的Integer的排序
            booked = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            booked.put(start, booked.getOrDefault(start, 0) + 1);
            booked.put(end, booked.getOrDefault(end, 0) - 1);

            // 活跃的连续时间
            int activeTimes = 0;
            for (Integer value : booked.values()) {
                activeTimes += value;
                if (activeTimes >= 3) {
                    // 无法加入时回撤已加入的start和end
                    booked.put(start, booked.getOrDefault(start, 0) - 1);
                    booked.put(end, booked.getOrDefault(end, 0) + 1);
                    return false;
                }
            }
            return true;
        }
    }
}
