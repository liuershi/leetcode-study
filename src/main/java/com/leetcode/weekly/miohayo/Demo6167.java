package com.leetcode.weekly.miohayo;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/9/4 10:34 上午
 * @Version 1.0
 */
public class Demo6167 {

    public static boolean checkDistances(String s, int[] distance) {
        int[] nums = new int[26];
        Arrays.fill(nums, -1);
        for (int i = 0; i < s.toCharArray().length; i++) {
            int index = s.charAt(i) - 'a';
            if (nums[index] == -1)
                nums[index] = i;
            else
                nums[index] = i - nums[index] - 1;
        }

        for (int i = 0; i < distance.length; i++) {
            if (nums[i] == -1) continue;
            if (nums[i] != distance[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkDistances("abaccb", new int[]{1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }
}
