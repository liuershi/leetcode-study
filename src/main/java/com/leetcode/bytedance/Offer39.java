package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/10/8 11:53 下午
 * @Version 1.0
 */
public class Offer39 {

    public int majorityElement(int[] nums) {
        // 一：按序遍历
        /*int len = nums.length >> 1;
        if (nums.length % 2 != 0) len++;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) >= len) return num;
        }
        return -1;*/

        // 二：排序完后该数字必定在中间
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }
}
