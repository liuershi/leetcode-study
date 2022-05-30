package com.leetcode.mianshi;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/5/13 10:41 下午
 * @Version 1.0
 */
public class Demo0105 {

    public boolean oneEditAway(String first, String second) {
        int firLen = first == null ? 0 : first.length();
        int secLen = second == null ? 0 : second.length();
        if (Math.abs(firLen - secLen) > 2) return false;
        if (first == null || second == null) return true;

        first = " " + first;
        second = " " + second;
        int[][] nums = new int[firLen + 1][secLen + 1];
        char[] firChars = first.toCharArray();
        char[] secChars = second.toCharArray();
        for (int i = 0; i <= firLen; i++) {
            nums[i][0] = i;
        }
        for (int i = 0; i <= secLen; i++) {
            nums[0][i] = i;
        }

        for (int i = 1; i <= firLen; i++) {
            for (int j = 1; j <= secLen; j++) {
                int left = nums[i][j - 1];
                int top = nums[i - 1][j];
                int leftAndTop = nums[i - 1][j - 1];
                int val = Math.min(Math.min(left, top), leftAndTop);
                if (firChars[i] == secChars[j]) {
                    nums[i][j] = val;
                } else {
                    nums[i][j] = val + 1;
                }
            }
        }

        return nums[firLen][secLen] < 2;
    }

    public static void main(String[] args) {
        Demo0105 demo0105 = new Demo0105();
        System.out.println(demo0105.oneEditAway("plda", "ros"));
    }
}
