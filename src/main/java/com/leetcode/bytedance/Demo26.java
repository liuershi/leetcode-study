package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/28 3:30 下午
 * @Version 1.0
 */
public class Demo26 {

    public int removeDuplicates(int[] nums) {
        int len = 0;
        if (nums == null || (len = nums.length) < 2)
            return len;

        // 使用快慢指针，从1开始，0的位置不可能变
        int fast = 1, slow = 1;
        while (fast < len) {
            // 当前快指针和前一个元素不一样时修改慢指针的值，并且移动慢指针加1
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
