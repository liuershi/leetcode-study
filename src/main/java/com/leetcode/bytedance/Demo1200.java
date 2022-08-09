package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangwei151
 * @date 2022/7/4 10:56
 */
public class Demo1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> rsp = new ArrayList<>();
        int len = arr.length;
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = i + 1; j < len; i++, j++) {
            int val = arr[j] - arr[i];
            if (val < min) {
                min = val;
                rsp.clear();
                rsp.add(Arrays.asList(arr[i], arr[j]));
            } else if (val == min) {
                rsp.add(Arrays.asList(arr[i], arr[j]));
            }
        }
        return rsp;
    }
}
