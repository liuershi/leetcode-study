package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/5/11 7:58 下午
 * @Version 1.0
 */
public class Demo1016 {

    public boolean queryString(String s, int n) {
        while (n > 0) {
            if (!s.contains(Integer.toBinaryString(n))) {
                return false;
            }
            n--;
        }
        return true;
    }
}
