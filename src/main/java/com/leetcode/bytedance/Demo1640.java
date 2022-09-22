package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/9/22 10:18 下午
 * @Version 1.0
 */
public class Demo1640 {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < pieces.length; i++) {
            Integer start = map.get(pieces[i][0]);
            for (int j = 1; j < pieces[i].length; j++) {
                if (start == null || start + j >= arr.length || arr[start + j] != pieces[i][j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Demo1640 demo1640 = new Demo1640();
        demo1640.canFormArray(new int[]{49,18,16}, new int[][]{{16,18,49}});
    }
}
