package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/9/2 10:37 下午
 * @Version 1.0
 */
public class Demo540 {

    public int singleNonDuplicate(int[] nums) {
//        return method1(nums);
        // 思路二：二分查询，由于只有一个数出现次数为1次，那么所有数的总次数为奇数，
        // 假设该数为x，那么x左侧或右侧的数都为偶数个。。。，详见参考：https://leetcode.cn/problems/single-element-in-a-sorted-array/solution/you-xu-shu-zu-zhong-de-dan-yi-yuan-su-by-y8gh/
        // 时间复杂度：O(logn) 空间复杂度：O(1)
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            // 说明：对于 mid ^ 1 而言，mid为奇数时等同于 mid - 1，mid为偶数时等同于 mid + 1
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else
                high = mid;
        }
        return nums[low];
    }

    private int method1(int[] nums) {
        // 思路一：异或运算
        // 时间复杂度：O(n) 空间复杂度：O(1)
        int res = 0;
        for (int num : nums) res ^= num;
        return res;
    }
}
