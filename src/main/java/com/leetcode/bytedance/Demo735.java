package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/7/13 12:07 上午
 * @Version 1.0
 */
public class Demo735 {

    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        List<Integer> list = new ArrayList<>(len);
//        int right = -1;
        for (int i = 0; i < len; i++) {
            int val = asteroids[i];
            if (val < 0) {
//                if (right == -1) right = i - 1;
                for (int j = i - 1; j >= 0; j--) {
                    int prev = asteroids[j];
                    if (prev == Integer.MIN_VALUE) continue;
                    if (prev < 0) break;
                    if (prev + val > 0) {
                        asteroids[i] = Integer.MIN_VALUE;
                        break;
                    } else if (prev + val == 0) {
                        asteroids[i] = asteroids[j] = Integer.MIN_VALUE;
                        break;
                    } else
                        asteroids[j] = Integer.MIN_VALUE;
                }
            }
        }
        for (int asteroid : asteroids) {
            if (asteroid != Integer.MIN_VALUE) list.add(asteroid);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
