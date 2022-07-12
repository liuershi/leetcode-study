package com.leetcode.oneTest;

import jdk.internal.org.objectweb.asm.tree.analysis.BasicValue;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/7/10 3:47 下午
 * @Version 1.0
 */
public class Demo91 {

    public int numDecodings(String s) {
        int len = s == null ? 0 : s.length();
        if (len == 0 || s.charAt(0) == '0') return 0;
        int[] nums = new int[len];
        nums[0] = 1;
        for (int i = 1; i < len; i++) {
            int val = s.charAt(i) - '0';
            if (val != 0)
                nums[i] += nums[i - 1];
            int prev = s.charAt(i - 1) - '0';
            if (prev == 1 || (prev == 2 && val <= 6)) {
                // 存在当前值为0，则需取前第二位的数，例如：2101
                int add = i > 1 ? nums[i - 2] : 1;
                nums[i] += add;
            }
        }
        return nums[len - 1];
    }
}
