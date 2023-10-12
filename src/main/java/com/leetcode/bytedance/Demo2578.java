package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2023/10/9 12:46 上午
 * @Version 1.0
 */
public class Demo2578 {

    public int splitNum(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        Arrays.sort(chars);
        int num1 = 0, num2 = 0;
        for (int i = 0; i < chars.length; i++) {
            if ((i & 1) == 1) {
                num1 = num1 * 10 + chars[i] - '0';
            } else {
                num2 = num2 * 10 + chars[i] - '0';
            }
        }
        return num1 + num2;
    }
}
