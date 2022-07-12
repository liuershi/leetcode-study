package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/11 11:42 下午
 * @Version 1.0
 */
public class Demo136 {

    public int singleNumber(int[] nums) {
        int rsp = 0;
        for (int num : nums) {
            rsp ^= num;
        }
        return rsp;
    }
}
