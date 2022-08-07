package com.leetcode.weekly.shenceshuju;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/8/6 11:07 下午
 * @Version 1.0
 */
public class Demo6174 {

    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Integer> map = new HashMap<>(tasks.length);
        int rsp = 0;
        for (int i = 0; i < tasks.length; i++) {
            Integer prev = map.getOrDefault(tasks[i], (int)-1e9);
            if (rsp >= prev + space) {
                rsp++;
                map.put(tasks[i], rsp);
            } else {
                rsp = prev + space + 1;
                map.put(tasks[i], rsp);
            }
        }

        return rsp;
    }
}
