package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

/**
 * @Author milindeyu
 * @Date 2022/12/20 11:10 下午
 * @Version 1.0
 */
public class Demo1760 {

    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        int res = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            long ops = 0;
            for (int num : nums) {
                ops += (num - 1) / mid;
            }
            if (ops <= maxOperations) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,8,2};
        Demo1760 demo1760 = new Demo1760();
        System.out.println(demo1760.minimumSize(nums, 4));
    }
}
