package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/11/2 11:23 下午
 * @Version 1.0
 */
public class Demo1620 {

    public int[] bestCoordinate(int[][] towers, int radius) {
        int minX = 51, minY = 51;
        int maxX = 0, maxY = 0;
        for (int[] tower : towers) {
            minX = Math.min(minX, tower[0]);
            minY = Math.min(minY, tower[1]);
            maxX = Math.max(maxX, tower[0]);
            maxY = Math.max(maxY, tower[1]);
        }

        int maxSignal = 0;
        int[] rsp = new int[2];
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                int signal = signalStrength(i, j, towers, radius);
                if (signal > maxSignal) {
                    maxSignal = signal;
                    rsp[0] = i;
                    rsp[1] = j;
                } else if (signal == maxSignal) {
                    if (i < rsp[0] || (i == rsp[0] && j < rsp[1])) {
                        rsp[0] = i;
                        rsp[1] = j;
                    }
                }
            }
        }
        return rsp;
    }

    private int signalStrength(int x, int y, int[][] towers, int radius) {
        int signal = 0;
        for (int[] tower : towers) {
            double distance = Math.sqrt(Math.pow(Math.abs(x - tower[0]), 2) + Math.pow(Math.abs(y - tower[1]), 2));
            if (distance <= radius) {
                signal += tower[2] / (1 + distance);
            }
        }
        return signal;
    }
}
