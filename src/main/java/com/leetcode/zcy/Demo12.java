package com.leetcode.zcy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/4/19 12:05 上午
 * @Version 1.0
 */
public class Demo12 {

    List<List<String>> result = new ArrayList<>();

    /**
     * 给定一个数组，得到其所有的全排列
     * @param nums
     * @return
     */
    public List<List<String>> permute(String[] nums) {
        if (nums == null || nums.length == 0) return result;
        LinkedList<String> list = new LinkedList<>();
        traceBack(nums, list);
        return result;
    }

    private void traceBack(String[] nums, LinkedList<String> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (String s : nums) {
            if (list.contains(s)) continue;
            list.add(s);
            traceBack(nums, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        String[] strings = {"1", "2", "3", "4"};
        Demo12 demo12 = new Demo12();
        System.out.println(demo12.permute(strings));
    }
}
