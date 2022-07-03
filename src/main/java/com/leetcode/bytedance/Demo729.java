package com.leetcode.bytedance;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author zhangwei151
 * @date 2022/6/6 16:03
 */
public class Demo729 {

    class MyCalendar {

        Set<int[]> set;

        public MyCalendar() {
            set = new TreeSet<int[]>((a, b) -> {
                if (b[0] >= a[1])
                    return -1;
                else if (a[0] >= b[1])
                    return 1;
                else
                    return 0;
            });
        }

        public boolean book(int start, int end) {
            return set.add(new int[]{start, end});
        }
    }
}
