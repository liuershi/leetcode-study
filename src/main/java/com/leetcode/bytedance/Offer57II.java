package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author milindeyu
 * @Date 2022/10/22 4:02 下午
 * @Version 1.0
 */
public class Offer57II {

    public int[][] findContinuousSequence(int target) {
        // 思路：滑动窗口
        List<List<Integer>> rsp = new ArrayList<>();
        int right = (target >> 1) + 1;
        int sum = 0;
        LinkedList<Integer> cur = new LinkedList<>();
        for (int i = 1; i <= right; i++) {
            sum += i;
            cur.addLast(i);
            if (sum > target) {
                while (sum > target) {
                    sum -= cur.removeFirst();
                }
            }
            if (sum == target) {
                rsp.add(new ArrayList<>(cur));
                sum -= cur.removeFirst();
            }
        }
        int[][] result = new int[rsp.size()][];
        for (int i = 0; i < rsp.size(); i++) {
            result[i] = rsp.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        return result;
    }
}
