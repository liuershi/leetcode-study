package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/3/15 8:52 下午
 * @Version 1.0
 */
public class Demo1615 {

    public int maximalNetworkRank(int n, int[][] roads) {
        // 记录每个城市连接的城市数
        int[] op = new int[n];
        // 记录城市I和J是否相连
        int[][] grip = new int[n][n];

        for (int[] road : roads) {
            grip[road[0]][road[1]] = grip[road[1]][road[0]] = 1;
            op[road[0]]++;
            op[road[1]]++;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                max = Math.max(max, op[i] + op[j] - grip[i][j]);
            }
        }
        return max;
    }
}
