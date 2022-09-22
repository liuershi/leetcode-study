package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/9/18 10:58 下午
 * @Version 1.0
 */
public class Demo1624 {

    public int maxLengthBetweenEqualCharacters(String s) {
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            int right = s.lastIndexOf(s.charAt(i));
            if (right != i) {
                res = Math.max(res, right - i - 1);
                if (res >= (s.length() - i - 2)) break;
            }
        }
        return res;
    }
}
