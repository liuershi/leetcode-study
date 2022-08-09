package com.leetcode.weekly.yinlian;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/8/7 10:53 上午
 * @Version 1.0
 */
public class Demo6139 {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {

        Set<Integer> exist = new HashSet<>(restricted.length);
        for (int i : restricted) {
            exist.add(i);
        }

        Map<Integer, List<Integer>> container = new HashMap<>();
        for (int[] edge : edges) {
            container.putIfAbsent(edge[0], new ArrayList<>());
            container.get(edge[0]).add(edge[1]);
            container.putIfAbsent(edge[1], new ArrayList<>());
            container.get(edge[1]).add(edge[0]);
        }

        boolean[] visitor = new boolean[n];
        visitor[0] = true;
        int rsp = 1;
        // 广度优先遍历
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            Integer key = stack.poll();
            List<Integer> list = container.get(key);
            if (list == null) continue;

            for (Integer val : list) {
                if (!visitor[val] && !exist.contains(val)) {
                    rsp++;
                    visitor[val] = true;
                    stack.offer(val);
                }
            }
        }
        return rsp;
    }
}
