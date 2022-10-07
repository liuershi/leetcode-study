package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/10/7 10:08 下午
 * @Version 1.0
 */
public class Demo1784 {

    public boolean checkOnesSegment(String s) {
        boolean res = true;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1' && s.charAt(i - 1) == '0') {
                res = false;
                break;
            }
        }
        return res;
    }
}
