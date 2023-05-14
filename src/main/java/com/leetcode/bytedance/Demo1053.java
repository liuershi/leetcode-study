package com.leetcode.bytedance;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Author milindeyu
 * @Date 2023/4/3 11:40 下午
 * @Version 1.0
 */
public class Demo1053 {

    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                Map.Entry<Integer, Integer> entry = map.lowerEntry(arr[i]);
                if (entry != null) {
                    arr[i] ^= arr[entry.getValue()];
                    arr[entry.getValue()] ^= arr[i];
                    arr[i] ^= arr[entry.getValue()];
                    break;
                }
            }
            map.put(arr[i], i);
        }
        return arr;
    }
}
