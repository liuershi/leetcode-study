package com.leetcode.bytedance;

/**
 * 存在重复数
 *  要求：时间复杂度O(n)，空间复杂度O(1)
 *  难点：空间复杂度O(1)
 *
 * @Author milindeyu
 * @Date 2022/7/29 11:30 下午
 * @Version 1.0
 */
public class Demo287 {

    public int findDuplicate(int[] nums) {
        // 使用哈希表实现，不过空间复杂度为O(n)
        // 最佳实践：基于快慢指针实现，将每一步的值抽象成链表，其存在重复元素会存在环，求出入环节点即可
        int slow = 0, fast = 0;
        while (true) {
            // nums中值范围在1～n，且nums的长度为n + 1所以不存在越界情况
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                // 此时快慢指针在环上的某个节点相遇，此时快指针从初始位置开始，一步一步走，慢指针同时一步一步走
                // 相遇的节点即为入环节点
                fast = 0;
                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                break;
            }
        }
        return slow;
    }
}
