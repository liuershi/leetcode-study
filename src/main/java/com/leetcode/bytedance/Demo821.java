package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/4/19 8:54 下午
 * @Version 1.0
 */
public class Demo821 {

    public int[] shortestToChar(String s, char c) {
        int[] nums = new int[s.length()];
        char[] chars = s.toCharArray();
        int i = s.indexOf(c);
        for (int j = 0; j < chars.length; j++) {
            nums[j] = Math.abs(i - j);
            if (j > i) {
                int tmp = s.indexOf(c, j);
                if (Math.abs(tmp - j) < nums[j]) {
                    i = tmp;
                    nums[j] = Math.abs(i - j);
                }

            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Demo821 demo821 = new Demo821();
        System.out.println(Arrays.toString(demo821.shortestToChar("loveleetcode", 'e')));
    }
}
