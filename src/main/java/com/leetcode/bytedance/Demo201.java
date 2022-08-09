package com.leetcode.bytedance;

/**
 * 数字范围按位与
 *
 * @Author milindeyu
 * @Date 2022/7/30 4:09 下午
 * @Version 1.0
 */
public class Demo201 {

    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }
}
