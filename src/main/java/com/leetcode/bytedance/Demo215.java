package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @link https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 * @Author milindeyu
 * @Date 2022/3/19 3:32 下午
 * @Version 1.0
 */
public class Demo215 {
    public static void main(String[] args) {
        Demo215 demo215 = new Demo215();
        System.out.println(demo215.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        // 方法一：使用jdk提供的排序算法
        /*Arrays.sort(nums);
        return nums[nums.length - k];*/

        // 方法二：使用优先级队列
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }
}
