package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 非递增顺序的最小子序列
 *
 * @Author milindeyu
 * @Date 2022/8/4 12:47 上午
 * @Version 1.0
 */
public class Demo1403 {


    /**
     * 总体思路：
     *      1. 先数组排序
     *      2. 求数组的总和
     *      3. 倒序求遍历的总和，当遍历的和大于总和的一半时认为符合条件，记录此时的下标index
     *      4. 从index位置向后遍历到数组尾的元素为符合条件
     * @param nums
     * @return
     */
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int left = sum, right = 0;
        int index = -1;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            right += nums[i];
            left -= nums[i];
            if (right > left) {
                index = i;
                break;
            }
        }
        List<Integer> rsp = new ArrayList<>();
        if (index == -1) return rsp;
        for (int i = nums.length - 1; i >= index; i--) {
            rsp.add(nums[i]);
        }
        return rsp;
    }
}
