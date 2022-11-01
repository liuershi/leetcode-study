package com.leetcode.weekly.twoweek.week90;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author milindeyu
 * @Date 2022/10/29 11:24 下午
 * @Version 1.0
 */
public class Demo6227 {

    public int[] secondGreaterElement(int[] nums) {
        int len = nums.length;
        int[] rsp = new int[len];
        Arrays.fill(rsp, -1);
        if (len < 3) return rsp;

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                boolean found = false;
                for (int j = i + 1; j < len; j++) {
                    if (nums[j] > nums[stack.peek()]) {
                        rsp[stack.pop()] = nums[j];
                        found = true;
                        break;
                    }
                }
                if (!found) break;
            }
            stack.push(i);
        }

        return rsp;
    }
}
