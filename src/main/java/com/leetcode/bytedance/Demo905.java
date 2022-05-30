package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/4/28 10:48 下午
 * @Version 1.0
 */
public class Demo905 {

    public static int[] sortArrayByParity(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        List<Integer> evenNums = new ArrayList<>();
        List<Integer> oddNums = new ArrayList<>();
        for (int num : nums) {
            if ((num & 1) == 1) {
                oddNums.add(num);
            } else {
                evenNums.add(num);
            }
        }
        evenNums.addAll(oddNums);
        return evenNums.stream().mapToInt(Integer::intValue).toArray();
    }
}
