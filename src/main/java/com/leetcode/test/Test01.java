package com.leetcode.test;

/**
 * @Author milindeyu
 * @Date 2022/5/15 1:27 下午
 * @Version 1.0
 */
public class Test01 {
    public int majorityElement(int[] nums) {
        int rsp = nums[0];
        int count = 1;
        for (int i : nums) {
            if (i != rsp)
                --count;
            else
                ++count;
            if (count == 0) {
                count = 1;
                rsp = i;
            }
        }
        return rsp;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        Test01 test01 = new Test01();
        System.out.println(test01.majorityElement(nums));
    }
}
