package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2023/2/28 12:16 上午
 * @Version 1.0
 */
public class Demo2363 {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(items1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(items2, Comparator.comparingInt(a -> a[0]));
        for (int i = 0, j = 0; i < items1.length || j < items2.length;) {
            if (i < items1.length && j < items2.length) {
                if (items1[i][0] == items2[j][0]) {
                    res.add(Arrays.asList(items1[i][0], items1[i][1] + items2[j][1]));
                    i++;
                    j++;
                } else if (items1[i][0] > items2[j][0]) {
                    res.add(Arrays.asList(items2[j][0], items2[j][1]));
                    j++;
                } else {
                    res.add(Arrays.asList(items1[i][0], items1[i][1]));
                    i++;
                }
            } else if (i < items1.length) {
                res.add(Arrays.asList(items1[i][0], items1[i][1]));
                i++;
            } else {
                res.add(Arrays.asList(items2[j][0], items2[j][1]));
                j++;
            }
        }
        return res;
    }
}
