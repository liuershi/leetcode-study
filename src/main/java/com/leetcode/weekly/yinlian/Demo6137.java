package com.leetcode.weekly.yinlian;

/**
 * @Author milindeyu
 * @Date 2022/8/7 11:21 上午
 * @Version 1.0
 */
public class Demo6137 {

    boolean rsp = false;
    public boolean validPartition(int[] nums) {
        helper(nums, 0, 1, 0);
        helper(nums, 0, 2, 1);
        helper(nums, 0, 2, 2);
        return rsp;
    }

    /**
     * 判断当前范围内的数字是否满足要求
     * @param nums 当前数组
     * @param start 起始下标
     * @param end 终止下标
     * @param type 判断类型。
     *             0：子数组 恰 由 2 个相等元素组成
     *             1：子数组 恰 由 3 个相等元素组成
     *             2：子数组 恰 由 3 个连续递增元素组成，并且相邻元素之间的差值为 1
     * @return
     */
    private void helper(int[] nums, int start, int end, int type) {
        if (end >= nums.length || rsp) return;
        boolean result = false;
        switch (type) {
            case 0:
            case 1:
                result = isSame(nums, start, end);
                break;
            case 2:
                if (nums[start + 1] - nums[start] == 1
                        && nums[end] - nums[start + 1] == 1) result = true;
                break;
            default:
                break;
        }
        if (nums.length - 1 == end || !result) {
            rsp = nums.length - 1 == end && result;
            return;
        }
        helper(nums, end + 1, end + 2, 0);
        helper(nums, end + 1, end + 3, 1);
        helper(nums, end + 1, end + 3, 2);
    }

    private boolean isSame(int[] nums, int start, int end) {
        int first = nums[start];
        for (int i = start + 1; i <= end; i++) {
            if (first != nums[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {993335,993336,993337,993338,993339,993340,993341};
        Demo6137 demo6137 = new Demo6137();
        System.out.println(demo6137.validPartition(nums));
    }













    //  正确方式：基于dp实现
    public boolean validPartitionSuccess(int[] nums) {
        int len = nums.length;
        boolean[] memo = new boolean[len + 1];
        memo[0] = true;
        memo[1] = false;
        for (int i = 2; i <= len; i++) {
            if (memo[i - 2] && nums[i - 1] == nums[i - 2]) memo[i] = true;
            if (i >= 3 && memo[i - 3] && nums[i - 1] == nums[i - 2] && nums[i - 1] == nums[i - 3]) memo[i] = true;
            if (i >= 3 && memo[i - 3] && nums[i - 3] + 1 == nums[i - 1] - 1) memo[i] = true;
        }
        return memo[len];
    }
}
