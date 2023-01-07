package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/1/3 12:06 上午
 * @Version 1.0
 */
public class Demo2042 {

    public boolean areNumbersAscending(String s) {
        int prev = -1;
        for (String val : s.split(" ")) {
            if (Character.isDigit(val.charAt(0))) {
                int num = Integer.parseInt(val);
                if (prev >= num) {
                    return false;
                }
                prev = num;
            }
        }
        return true;
    }
}
