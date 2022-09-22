package com.leetcode.weekly.nio.week306;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/8/14 10:41 上午
 * @Version 1.0
 */
public class Demo6149 {

    public int edgeScore(int[] edges) {
        Map<Integer, Integer> map = new HashMap<>(edges.length);
        int max = 0;
        int res = edges.length;
        for (int i = 0; i < edges.length; i++) {
            map.put(edges[i], map.getOrDefault(edges[i], 0) + i);
            if (map.get(edges[i]) > max) {
                res = edges[i];
                max = map.get(edges[i]);
            } else if (max == map.get(edges[i])) res = Math.min(res, edges[i]);
        }
        return res;
    }
}
