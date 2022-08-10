package com.leetcode.weekly.yinlian.week293;

import java.util.LinkedList;

/**
 *
 *  https://leetcode.cn/contest/weekly-contest-293/problems/largest-combination-with-bitwise-and-greater-than-zero/
 *
 * @Author milindeyu
 * @Date 2022/8/10 10:36 下午
 * @Version 1.0
 */
public class Demo2275 {

    int res = 1;
    int len;
    public int largestCombination(int[] candidates) {
        len = candidates.length;
        helper(candidates, new LinkedList<>(), 0);
        return res;
    }

    private void helper(int[] candidates, LinkedList<Integer> path, int start) {
        if (res == len) return;
        if (path.size() > res) {
            int val = candidates[path.get(0)];
            for (int i = 1; i < path.size(); i++) {
                val &= candidates[path.get(i)];
                if (val == 0) return;
            }
            res = path.size();
        }
        if (path.size() == len) return;
        for (int i = start; i < len; i++) {
            if (path.contains(i)) continue;
            path.addLast(i);
            helper(candidates, path, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Demo2275().largestCombination(new int[]{33,93,31,99,74,37,3,4,2,94,77,10,75,54,24,95,65,100,41,82,35,65,38,49,85,72,67,21,20,31}));
    }
}
