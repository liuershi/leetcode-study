package com.leetcode.weekly.twoweek.week85;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/8/20 10:46 下午
 * @Version 1.0
 */
public class Demo6158 {

    public String shiftingLetters(String s, int[][] shifts) {
        char[] chars = s.toCharArray();
        int[] nums = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            nums[i] = chars[i] - 'a';
        }
        // 注意：该题的难点在于，对于shifts范围内的元素，进行范围累加或减法时
        // 通过差分数组实现才行，否则是否循环单个处理会超时
        int[] diff = new int[chars.length];
        diff[0] = nums[0];
        for (int i = 1; i < diff.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }

        for (int[] shift : shifts) {
            int l = shift[0], r = shift[1];
            int v = shift[2] == 1 ? 1 : -1;
            diff[l] += v;
            if (r + 1 < diff.length)
                diff[r + 1] -= v;
        }

        // 还原数组
        nums[0] = diff[0] % 26;
        for (int i = 1; i < diff.length; i++) {
            nums[i] = (nums[i - 1] + diff[i]) % 26;
        }


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) chars[i] = (char) (nums[i] + 26);
            else chars[i] = (char) (nums[i] + 'a');
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(-27 % 26);
    }
}
