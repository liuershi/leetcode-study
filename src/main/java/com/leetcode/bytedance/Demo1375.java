package com.leetcode.bytedance;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @Author milindeyu
 * @Date 2023/6/14 1:29 上午
 * @Version 1.0
 */
public class Demo1375 {

    public int numTimesAllBlue(int[] flips) {
//        return method1(flips);
        int ans = 0, max = 0;
        for (int i = 0; i < flips.length; i++) {
            max = Math.max(max, flips[i]);
            if (max == i + 1) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 超时
     * @param flips
     * @return
     */
    private int method1(int[] flips) {
        int n = flips.length, ans = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            if (map.isEmpty()) {
                map.put(flips[i], 1);
            } else {
                Map.Entry<Integer, Integer> entry = map.floorEntry(flips[i]);
                map.put(flips[i], entry == null ? 1 : entry.getValue() + 1);
                Map.Entry<Integer, Integer> higherEntry = map.higherEntry(flips[i]);
                while (higherEntry != null) {
                    map.put(higherEntry.getKey(), higherEntry.getValue() + 1);
                    higherEntry = map.higherEntry(higherEntry.getKey());
                }
            }
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            if (Objects.equals(entry.getValue(), entry.getKey())) {
                ans++;
            }
        }
        return ans;
    }
}
