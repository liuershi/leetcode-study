package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/27 9:53 下午
 * @Version 1.0
 */
public class Demo461 {

    public int hammingDistance(int x, int y) {
        // 思路：该题等同于求两数按位异或之后的数中二进制中1的位数
        return Integer.bitCount(x ^ y);
    }
}
