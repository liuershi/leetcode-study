package com.leetcode.bytedance;


/**
 * 长度最小的子数组
 *
 * @Author milindeyu
 * @Date 2022/7/30 4:04 下午
 * @Version 1.0
 */
public class Demo209 {

    public int minSubArrayLen(int target, int[] nums) {

        int start = 0;
        int sum = 0;
        int len = 0;
        // 基于滑动窗口实现
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                len = len == 0 ? end - start + 1 : Math.min(len, end - start + 1);
                sum -= nums[start++];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Demo209 demo209 = new Demo209();
        System.out.println(demo209.minSubArrayLen(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8}));
    }
}
