package com.leetcode.bytedance;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author milindeyu
 * @Date 2023/7/19 12:33 上午
 * @Version 1.0
 */
public class Demo874 {

    public int robotSim(int[] commands, int[][] obstacles) {
        // 思路：基于set，先将障碍放进set中
        // 1.将障碍物对应的二维坐标转一维，理论：https://leetcode.cn/problems/walking-robot-simulation/solution/python3javacgotypescript-yi-ti-yi-jie-ha-ghjx/
        // 所以二维 (x, y) 转一维为：x * n + y ，该题中x和y范围在 -30000 和 30000 之间，所以n取60001
        Set<Integer> set = new HashSet<>(obstacles.length);
        fill(set, obstacles);
        int max = 0, x = 0, y = 0;
        // 用相邻两位表示方向，从北、东、南、西
        int[] directs = {0, 1, 0, -1, 0};
        int direct = 0;
        for (int command : commands) {
            if (command < 0) {
                // 此时转变方向
                if (command == -1) {
                    // 向左转，可以理解为向右转3次
                    direct += 3;
                } else {
                    // 向右
                    direct++;
                }
                direct %= 4;
            } else {
                // 按指定方向移动指定距离，若出现障碍直接跳出
                int count = command;
                while (count-- > 0) {
                    if (set.contains(transfer(x + directs[direct], y + directs[direct + 1]))) {
                        break;
                    }
                    x += directs[direct];
                    y += directs[direct + 1];
                }
                max = Math.max(max, x * x + y * y);
            }
        }
        return max;
    }

    private void fill(Set<Integer> set, int[][] obstacles) {
        for (int[] obstacle : obstacles) {
            set.add(transfer(obstacle[0], obstacle[1]));
        }
    }

    private int transfer(int x, int y) {
        return x * 60001 + y;
    }
}
