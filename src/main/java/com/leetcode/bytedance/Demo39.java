package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/5/20 10:39 下午
 * @Version 1.0
 */
public class Demo39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rsp = new ArrayList<>();
        Arrays.sort(candidates);
        LinkedList<Integer> list = new LinkedList<>();
        process(rsp, list, target, candidates, 0);
        return rsp;
    }

    private void process(List<List<Integer>> rsp, LinkedList<Integer> list, int current, int[] candidates, int start) {
        if (current < 0) return;
        if (current == 0) {
            rsp.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.addLast(candidates[i]);
            process(rsp, list, current - candidates[i], candidates, i);
            list.removeLast();
        }
    }
}
