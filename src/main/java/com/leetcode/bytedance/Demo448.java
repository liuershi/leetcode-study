package com.leetcode.bytedance;

import java.util.*;

/**
 * 找到数组值所有消失的数字
 *
 * @Author milindeyu
 * @Date 2022/7/29 11:42 下午
 * @Version 1.0
 */
public class Demo448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
//        return method1(nums);

        int n = nums.length;
        for (int num : nums) {
            // 需要取余，不然可能导致下标越界
            int index = (num - 1) % n;
            nums[index] += n;
        }

        List<Integer> rsp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= n) rsp.add(i + 1);
        }
        return rsp;
    }

    private List<Integer> method1(int[] nums) {
        // 将所有正数作为数组下标，置对应数组值为负值。那么，仍为正数的位置即为（未出现过）消失的数字。
        //
        // 举个例子：
        //
        // 原始数组：[4,3,2,7,8,2,3,1]
        //
        // 重置后为：[-4,-3,-2,-7,8,2,-3,-1]
        //
        // 结论：[8,2] 分别对应的index为[5,6]（消失的数字）
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }

        List<Integer> rsp = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) rsp.add(i + 1);
        }
        return rsp;
    }
}
