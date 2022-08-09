package com.leetcode.weekly.shenceshuju;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author milindeyu
 * @Date 2022/8/6 10:33 下午
 * @Version 1.0
 */
public class Demo01 {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> container = new HashMap<>(items1.length + items1.length);
        for (int[] nums : items1) {
            container.put(nums[0], nums[1]);
        }
        for (int[] nums : items2) {
            container.put(nums[0], container.getOrDefault(nums[0], 0) + nums[1]);
        }
        return container.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getKey)).map(entry -> Arrays.asList(entry.getKey(), entry.getValue())).collect(Collectors.toList());
    }

    public static void main(String[] args) {

    }
}
