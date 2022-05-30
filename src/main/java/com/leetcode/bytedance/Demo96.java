package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/5/29 10:16 下午
 * @Version 1.0
 */
public class Demo96 {

    public int numTrees(int n) {
        if (n < 3) return n;

        List<List<Integer>> rsp = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }


        traceBack(rsp, n, nums, new LinkedList<Integer>());
        return rsp.size();
    }

    private void traceBack(List<List<Integer>> rsp, int len, int[] nums, LinkedList<Integer> path) {
        if (path.size() == len) {
            rsp.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (path.contains(nums[i]))
                continue;

        }
    }
}
