package com.leetcode.bytedance;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Author milindeyu
 * @Date 2024/2/1 1:13 上午
 * @Version 1.0
 */
public class Demo1122 {


    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>(arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        List<Integer> list = new ArrayList<>(arr1.length);
        for (int i : arr1) {
            list.add(i);
        }

        list.sort((o1, o2) -> {
            Integer idx1 = map.getOrDefault(o1, arr1.length);
            Integer idx2 = map.getOrDefault(o2, arr1.length);
            if (idx1.equals(idx2)) {
                return o1 - o2;
            }
            return idx1 - idx2;
        });

        for (int i = 0; i < list.size(); i++) {
            arr1[i] = list.get(i);
        }

        return arr1;
    }
}
