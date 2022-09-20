package com.leetcode.weekly.twoweek.week86;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/9/3 10:42 下午
 * @Version 1.0
 */
public class Demo6171 {

    public boolean findSubarrays(int[] nums) {
        TreeSet<int[]> set = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] + o1[1] == o2[0] + o2[1]) return 0;
                else {
                    if (o1[0] == o2[0]) return o1[1] - o2[1];
                    else return o1[0] - o2[0];
                }
            }
        });
        for (int i = 1; i < nums.length; i++) {
            if (!set.add(new int[]{nums[i - 1], nums[i]})) return true;
        }
        return false;
    }
}
