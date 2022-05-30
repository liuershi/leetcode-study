package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/28 4:14 下午
 * @Version 1.0
 */
public class Demo81 {

    public boolean search(int[] nums, int target) {
        int len;
        if (nums == null || (len = nums.length) < 2)
            return nums != null && nums[0] == target;

        // 表示值最大的下标
        int idx = 0;
        while (idx < len - 1 && nums[idx] <= nums[idx + 1]) {
            if (nums[idx++] == target)
                return true;
        }

        if (nums[idx] == target) return true;
        if (idx + 1 == len || nums[idx] < target || target < nums[idx + 1]) return false;

        int left = idx + 1, right = len - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            int val = nums[middle];
            if (val == target)
                return true;
            else if (val < target)
                left = middle + 1;
            else
                right = middle - 1;
        }
        return false;
    }
}
