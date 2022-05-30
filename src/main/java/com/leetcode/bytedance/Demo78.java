package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/5/26 11:10 下午
 * @Version 1.0
 */
public class Demo78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rsp = new ArrayList<>();
        rsp.add(new ArrayList<>());
        int len;
        if (nums == null || (len = nums.length) == 0) return rsp;

        trackBack(rsp, nums, len, 0, new LinkedList<>());
        return rsp;
    }

    private void trackBack(List<List<Integer>> rsp, int[] nums, int len, int begin, LinkedList<Integer> list) {
        if (!list.isEmpty()) {
            rsp.add(new ArrayList<>(list));
        }

        for (int i = begin; i < len; i++) {
            list.addLast(nums[i]);
            trackBack(rsp, nums, len, i + 1, list);
            list.removeLast();
        }
    }
}
