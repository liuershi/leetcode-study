package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/11 11:38 下午
 * @Version 1.0
 */
public class Demo926 {

    public int minFlipsMonoIncr(String s) {
        int len = 0;
        if (s == null || (len = s.length()) < 1) return len;
        // 动态规划方式
        int oneCnt = 0, flip = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                // 统计字符串中1的个数
                oneCnt++;
            } else {
                // 如果当前字符串为0时，有两种情况
                // 第一：当前字符由0翻转为1，此时在已经翻转的基础上加1即可
                // 第二：当前字符不变，将当前字符前面字符串（即0～i-1）中的1翻转为0
                // 这两种情况取其中翻转次数较小的一种
                flip = Math.min(oneCnt, flip + 1);
            }
        }
        return flip;
    }
}
