package com.leetcode.weekly.yinlian.week315;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/10/17 10:18 下午
 * @Version 1.0
 */
public class Demo2442 {

    public static int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            set.add(Integer.parseInt(new StringBuilder().append(num).reverse().toString()));
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] nums = {1,13,10,12,31};
        System.out.println(countDistinctIntegers(nums));
    }
}
