package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/5/22 10:44 下午
 * @Version 1.0
 */
public class Demo56 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> rsp = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0], right = intervals[i][1];
            if (rsp.isEmpty() || left > rsp.get(rsp.size() - 1)[1]) {
                rsp.add(new int[]{left, right});
            } else {
                rsp.get(rsp.size() - 1)[1] = Math.max(rsp.get(rsp.size() - 1)[1], right);
            }
        }
        return rsp.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Demo56 demo56 = new Demo56();
        int[][] nums = {{1,4},{0,2},{3,5}};
        demo56.merge(nums);
    }
}
