package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author milindeyu
 * @Date 2022/10/7 9:16 下午
 * @Version 1.0
 */
public class Demo1800 {

    public int maxAscendingSum(int[] nums) {
        // 思路：顺序遍历，判断当前索引值与前一个索引值对于数的大小
        // 时间复杂度：O(n) 空间复杂度：O(1)
        int index = 1, sum = nums[0], max = nums[0];
        while (index < nums.length) {
            if (nums[index - 1] < nums[index]) {
                sum += nums[index++];
            } else {
                sum = nums[index++];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int count = 20;
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(nums));
    }
}
