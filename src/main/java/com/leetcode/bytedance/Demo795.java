package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/11/24 11:19 下午
 * @Version 1.0
 */
public class Demo795 {

    public int numSubarrayBoundedMax(int[] nums, int L, int R) {
//        return method01(nums, left, right);
        // 思路二：最大值在L和R之间的数组个数 = 最大值小于等于R数组个数 - 最大值小于L的数组个数
        return arrayNumberByMax(nums, R) - arrayNumberByMax(nums, L - 1);
    }

    /**
     * 最大值为Max的子数组
     * @param nums 数组
     * @param max 最大值
     * @return
     */
    private int arrayNumberByMax(int[] nums, int max) {
        int res = 0;
        int arrNum = 0;
        for (int num : nums) {
            if (num <= max) {
                res += ++arrNum;
            } else {
                arrNum = 0;
            }
        }
        return res;
    }

    /**
     * 一次遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int method01(int[] nums, int left, int right) {
        int rsp = 0;
        // start为每个子区间的起始位置
        int start = 0;
        // prev为上个大于等于left值的下标
        int prev = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                start = i + 1;
            }

            if (nums[i] >= left) {
                prev = i;
            }

            rsp += prev - start + 1;
        }
        return rsp;
    }
}
