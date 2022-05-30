package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/5/21 4:52 下午
 * @Version 1.0
 */
public class Demo47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rsp = new ArrayList<>();
        if (nums == null) return rsp;
        Arrays.sort(nums);
        boolean[] selected = new boolean[nums.length];
        process(rsp, nums, new LinkedList<>(), selected);
        return rsp;
    }

    private void process(List<List<Integer>> rsp, int[] nums, LinkedList<Integer> list, boolean[] selected) {
        if (list.size() == nums.length) {
            rsp.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 已选择元素去重
            if (selected[i])
                continue;
            int current = nums[i];
            // 当前元素和它之前元素重复且之前元素未选择时，直接跳过
            if (i > 0 && current == nums[i - 1] && !selected[i - 1])
                continue;
            selected[i] = true;
            list.addLast(current);
            process(rsp, nums, list, selected);
            list.removeLast();
            selected[i] = false;
        }
    }

    public static void main(String[] args) {
        Demo47 demo47 = new Demo47();
        int[] nums = {1,1,2};
        System.out.println(demo47.permuteUnique(nums));
    }
}
