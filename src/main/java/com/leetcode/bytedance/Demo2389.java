package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @Author milindeyu
 * @Date 2023/3/17 10:25 下午
 * @Version 1.0
 */
public class Demo2389 {

    public int[] answerQueries(int[] nums, int[] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        Arrays.sort(nums);
        TreeSet<int[]> set = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < nums.length; i++) {
            if (!set.isEmpty()) {
                set.add(new int[]{set.last()[0] + nums[i], set.last()[1]});
            } else {
                set.add(new int[]{nums[i], 1});
            }
        }

        for (int i = 0; i < n; i++) {
            int[] floor = set.floor(new int[]{queries[i], 0});
            answer[i] = floor == null ? 0 : floor[1];
        }
        return answer;
    }
}
