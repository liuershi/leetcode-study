package com.leetcode.bytedance;

import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/6/1 12:02 上午
 * @Version 1.0
 */
public class Demo120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = triangle.get(size - 1).get(i);
        }
        for (int i = size - 2; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int i1 = 0; i1 < list.size(); i1++) {
                nums[i1] = list.get(i1) + Math.min(nums[i1], nums[i1 + 1]);
            }
        }
        return nums[0];
    }
}
