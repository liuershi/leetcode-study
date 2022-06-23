package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/23 11:22 下午
 * @Version 1.0
 */
public class Demo547 {

    int[][] isConnected;
    int rsp, n;
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        this.isConnected = isConnected;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    rsp++;
                    isConnected[i][j] = 0;
                    infectedI(i, j);
                    infectedJ(j, i);
                    break;
                }
            }
        }
        return rsp;
    }

    private void infectedI(int i, int begin) {
        for (int j = begin; j < n; j++) {
            if (isConnected[i][j] == 1) {
                isConnected[i][j] = 0;
                infectedJ(j, 0);
            }
        }
    }

    private void infectedJ(int j, int begin) {
        for (int i = begin; i < n; i++) {
            if (isConnected[i][j] == 1) {
                isConnected[i][j] = 0;
                infectedI(i, 0);
            }
        }
    }
}
