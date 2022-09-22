package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/14 5:11 下午
 * @Version 1.0
 */
public class Demo1422 {

    public int maxScore(String s) {
        int oneSize = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') oneSize++;
        }

        int leftZeroSize = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') leftZeroSize++;
            res = Math.max(res, leftZeroSize + oneSize - (i + 1 - leftZeroSize));
        }
        return res;
    }
}
