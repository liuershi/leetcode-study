package com.leetcode.mianshi;

/**
 * @Author milindeyu
 * @Date 2022/8/15 10:36 下午
 * @Version 1.0
 */
public class Demo13 {

    public int movingCount(int m, int n, int k) {
        // 使用boolean类型替换int节省空间
        // 注意：虽然boolean只占一位，但是如果单独使用boolean类型底层还是会使用int来实现，所以这时候是占用4字节，也即32位
        // 但是，如果使用boolean类型数组，底层则会使用byte来实现，也就是只占1字节
        boolean[][] visitor = new boolean[m][n];
        return spread(m, n, k,0, 0, visitor);
    }

    private int spread(int m, int n, int k, int row, int col, boolean[][] visitor) {
        if (row == m || row < 0 || col == n || col < 0 || visitor[row][col]) return 0;
        // 由于题目给定了只m和n的范围在0～99之间，那么位数和的计算如下
        int bitNumberSum = row / 10 + row % 10 + col / 10 + col % 10;
        if (bitNumberSum > k) return 0;
        visitor[row][col] = true;
        return spread(m, n, k, row + 1, col, visitor)
                + spread(m, n, k, row - 1, col, visitor)
                + spread(m, n, k, row, col + 1, visitor)
                + spread(m, n, k, row, col - 1, visitor)
                + 1;
    }
}
