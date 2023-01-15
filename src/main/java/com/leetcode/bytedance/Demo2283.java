package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/1/11 9:23 下午
 * @Version 1.0
 */
public class Demo2283 {

    public boolean digitCount(String num) {
        char[] chars = num.toCharArray();
        int[] memo = new int[10];
        for (int i = 0; i < chars.length; i++) {
            ++memo[chars[i] - '0'];
        }

        // 重新检查
        for (int i = 0; i < chars.length; i++) {
            if (memo[i] != (chars[i] - '0')) {
                return false;
            }
        }
        return true;
    }
}
