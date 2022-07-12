package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/12 10:49 下午
 * @Version 1.0
 */
public class Demo191 {

    public int hammingWeight(int n) {
        int rsp = 0;
        for (char c : Integer.toBinaryString(n).toCharArray()) {
            if (c == '1') rsp++;
        }
        return rsp;
    }
}
