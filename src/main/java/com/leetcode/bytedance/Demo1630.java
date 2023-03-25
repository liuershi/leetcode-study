package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author milindeyu
 * @Date 2023/3/23 10:56 下午
 * @Version 1.0
 */
public class Demo1630 {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        // 方法一：暴力
        int n = l.length;
        List<Boolean> res = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int left = l[i], right = r[i];
            int minv = nums[left], maxv = nums[left];
            for (int j = left + 1; j <= right; j++) {
                minv = Math.min(minv, nums[j]);
                maxv = Math.max(maxv, nums[j]);
            }

            // 说明此时等差数列差值为0
            if (minv == maxv) {
                res.add(true);
                continue;
            }

            int diff = (maxv - minv) % (right - left);
            if (diff != 0) {
                res.add(false);
                continue;
            }

            diff = (maxv - minv) / (right - left);
            boolean[] exist = new boolean[right - left + 1];
            boolean valid = true;
            for (int j = left; j <= right; j++) {
                if ((nums[j] - minv) % diff != 0) {
                    valid = false;
                    break;
                }
                int index = (nums[j] - minv) / diff;
                if (exist[index]) {
                    valid = false;
                    break;
                }
                exist[index] = true;
            }
            res.add(valid);
        }
        return res;
    }

    public static void main(String[] args) {
        Demo1630 demo1630 = new Demo1630();
        System.out.println(demo1630.checkArithmeticSubarrays(
                new int[]{7, -6, -3, 0, 0, 0, 0, -8, 2, 16, 8, 12, 4, -5},
                new int[]{9, 9, 3, 5, 1},
                new int[]{12, 12, 6, 6, 4}
        ));
    }
}
