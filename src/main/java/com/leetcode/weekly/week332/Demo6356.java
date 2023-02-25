package com.leetcode.weekly.week332;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2023/2/12 9:35 下午
 * @Version 1.0
 */
public class Demo6356 {

    public int[][] substringXorQueries(String s, int[][] queries) {
        // 思路：遍历字符串s中所有的可能性
        int[] notFound = {-1, -1};
        char[] chars = s.toCharArray();
        Map<Integer, int[]> container = new HashMap<>();
        for (int i = 0, n = s.length(); i < n; i++) {
            for (int j = i, val = 0; j < Math.min(n, i + 30); j++) {
                val = val << 1 | (chars[j] & 1);
                if (!container.containsKey(val) || j - i < container.get(val)[1] - container.get(val)[0]) {
                    container.put(val, new int[]{i, j});
                }
            }
        }

        int[][] res = new int[queries.length][];
        for (int i = 0; i < queries.length; i++) {
            res[i] = container.getOrDefault(queries[i][0] ^ queries[i][1], notFound);
        }
        return res;
    }
}
