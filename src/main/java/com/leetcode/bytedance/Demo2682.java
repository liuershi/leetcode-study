package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2023/8/16 10:44 下午
 * @Version 1.0
 */
public class Demo2682 {

    public int[] circularGameLosers(int n, int k) {
        int[] nums = new int[n];
        int idx = 0, i = 1;
        nums[idx] = 1;
        while(true) {
            idx += i++ * k;
            idx %= n;
            if (++nums[idx] == 2) {
                break;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (nums[j] == 0) {
                ans.add(j + 1);
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
