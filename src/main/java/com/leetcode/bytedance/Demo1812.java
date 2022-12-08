package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/12/8 9:20 下午
 * @Version 1.0
 */
public class Demo1812 {

    public boolean squareIsWhite(String coordinates) {
        int row = coordinates.charAt(1), col = coordinates.charAt(0) - 'a' + 1;
        return ((col & 1) == 1 && (row & 1) == 0) || ((col & 1) == 0 && (row & 1) == 1);
    }
}
