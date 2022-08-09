package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/8/7 5:57 下午
 * @Version 1.0
 */
public class Demo636 {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] rsp = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();
        for (String log : logs) {
            String[] strings = log.split(":");
            int id = Integer.parseInt(strings[0]);
            int time = Integer.parseInt(strings[2]);
            if ("start".equals(strings[1])) {
                stack.push(new int[]{id, time});
            } else {
                int[] prev = stack.poll();
                int interval = time - prev[1] + 1;
                rsp[prev[0]] += interval;
                if (!stack.isEmpty()) {
                    rsp[stack.peek()[0]] -= interval;
                }
            }
        }
        return rsp;
    }
}
