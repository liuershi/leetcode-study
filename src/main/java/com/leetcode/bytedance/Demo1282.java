package com.leetcode.bytedance;

import java.util.*;

/**
 * https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/
 *
 * 每日一题
 *
 * @Author milindeyu
 * @Date 2022/8/12 11:03 下午
 * @Version 1.0
 */
public class Demo1282 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> container = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (groupSizes[i] == 1) {
                res.add(Collections.singletonList(i));
                continue;
            }
            List<Integer> nums = container.getOrDefault(groupSizes[i], new ArrayList<>());
            if (nums.size() == groupSizes[i] - 1) {
                container.remove(groupSizes[i]);
                nums.add(i);
                res.add(nums);
            } else {
                nums.add(i);
                container.put(groupSizes[i], nums);
            }
        }
        return res;
    }
}
