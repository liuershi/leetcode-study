package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/28 2:55 下午
 * @Version 1.0
 */
public class Demo80 {

    public int removeDuplicates(int[] nums) {
        int len = 0;
        if (nums == null || (len = nums.length) < 3)
            return len;

        // 同 {@link Demo26} 一样，使用快慢指针
        int fast = 2, slow = 2;
        while (fast < len) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
