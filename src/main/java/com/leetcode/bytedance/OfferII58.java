package com.leetcode.bytedance;

/**
 *  左旋字符串
 *
 * @Author milindeyu
 * @Date 2022/7/31 10:45 下午
 * @Version 1.0
 */
public class OfferII58 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
