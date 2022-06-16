package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/6/16 12:03 上午
 * @Version 1.0
 */
public class Demo532 {

    public int findPairs(int[] nums, int k) {
//        return method1(nums, k);

        // 排序后二分查询
        // 时间复杂度：O(n\log n)O(nlogn)，其中 nn 是数组 \text{nums}nums 的长度。排序需要消耗 O(n\log n)O(nlogn) 复杂度，遍历指针 xx 消耗 O(n)O(n) 复杂度，指针 yy 的值最多变化 O(n)O(n) 次，总的时间复杂度为 O(n\log n)O(nlogn)。
        //空间复杂度：O(\log n)O(logn)，其中 nn 是数组 \text{nums}nums 的长度。排序消耗 O(\log n)O(logn) 复杂度，其余消耗常数空间复杂度，总的空间复杂度为 O(\log n)O(logn)。
        Arrays.sort(nums);
        int left = 0, right = 1, len = nums.length, rsp = 0;
        while (left < len) {
            // left向右移动跳过重复数字
            while (left < len - 1 && nums[left] == nums[left + 1]) left++;
            // right 向右移动到差值k的位置
            while (right < len && nums[right] - nums[left] < k) right++;
            // 若右边移动到数组外，直接跳出循环
            if (right == len) break;

            if (left != right && nums[right] - nums[left] == k) rsp++;
            // right移动跳过重复数字
            while (right < len - 1 && nums[right] == nums[right + 1]) right++;
            // left右移，否则会死循环
            ++left;
        }
        return rsp;
    }

    public static void main(String[] args) {
        Demo532 demo532 = new Demo532();
        int[] nums = {1,2,4,4,3,3,0,9,2,3};
        System.out.println(demo532.findPairs(nums, 3));
    }

    /**
     * 利用set去重实现
     *      时间和空间复杂度都为 O(n)
     * @param nums
     * @param k
     * @return
     */
    private int method1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> rspSet = new HashSet<>();
        for (int num : nums) {
            // 由于取的是绝对值，所以 k 的值可能是 nums[i] - nums[j] 或者 nums[j] - nums[i]
            int less = num - k, more = num + k;
            // 存在数对时将数对 较小值 存入set，利用set去重特性
            if (set.contains(less)) rspSet.add(less);
            if (set.contains(more)) rspSet.add(num);
            set.add(num);
        }
        return rspSet.size();
    }
}
