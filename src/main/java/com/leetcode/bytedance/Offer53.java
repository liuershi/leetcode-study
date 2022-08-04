package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/4 11:55 下午
 * @Version 1.0
 */
public class Offer53 {

    public int search(int[] nums, int target) {
        int rsp = 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                rsp++;
                left = middle - 1;
                right = middle + 1;
                while (left >= 0 && nums[left--] == target) rsp++;
                while (right < nums.length && nums[right++] == target) rsp++;
                break;
            } else if (nums[middle] > target) right = middle - 1;
            else left = middle + 1;
        }
        return rsp;
    }
}
