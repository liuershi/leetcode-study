package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/5/22 11:18 下午
 * @Version 1.0
 */
public class Demo57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = new int[intervals.length + 1][2];
        System.arraycopy(intervals, 0, newIntervals, 0, intervals.length);
        newIntervals[intervals.length] = newInterval;
        Arrays.sort(newIntervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> rsp = new ArrayList<>();
        for (int i = 0; i < newIntervals.length; i++) {
            int left = newIntervals[i][0], right = newIntervals[i][1];
            if (rsp.isEmpty() || left > rsp.get(rsp.size() - 1)[1])
                rsp.add(new int[]{left, right});
            else
                rsp.get(rsp.size() - 1)[1] = Math.max(rsp.get(rsp.size() - 1)[1], right);
        }
        return rsp.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Demo57 demo57 = new Demo57();
        int[][] intervals = {{1,3},{6,9}};
        int[] interval = {2,5};
        demo57.insert(intervals, interval);
    }
}
