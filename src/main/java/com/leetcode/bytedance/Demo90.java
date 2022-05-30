package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/5/28 11:35 下午
 * @Version 1.0
 */
public class Demo90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rsp = new ArrayList<>();
        Arrays.sort(nums);
        process(nums.length, nums, new LinkedList<Integer>(), rsp, 0);
        return rsp;
    }

    private void process(int length, int[] nums, LinkedList<Integer> path, List<List<Integer>> rsp, int begin) {
        rsp.add(new ArrayList<>(path));
        if (begin == length) return;

        for (int i = begin; i < length; i++) {
            if (i > begin && nums[i] == nums[i - 1])
                continue;

            path.addLast(nums[i]);
            process(length, nums, path, rsp, i + 1);
            path.removeLast();
        }
    }
}
