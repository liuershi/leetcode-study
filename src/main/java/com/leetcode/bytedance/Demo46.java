package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/3/20 6:33 下午
 * @Version 1.0
 */
public class Demo46 {

    List<List<Integer>> rep = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, track);
        return rep;
    }

    void backTrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            rep.add(new ArrayList<>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num))
                continue;
            track.add(num);
            backTrack(nums, track);
            // 取消选择开始回溯
            track.removeLast();
        }
    }
}
