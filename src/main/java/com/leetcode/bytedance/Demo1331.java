package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangwei151
 * @date 2022/7/28 15:35
 */
public class Demo1331 {

    public int[] arrayRankTransform(int[] arr) {
        int[] copyArr = arr.clone();
        Arrays.sort(copyArr);
        Map<Integer, Integer> valMappingIndex = new HashMap<>(arr.length);
        int existCount = 0;
        for (int i = 0; i < copyArr.length; i++) {
            if (valMappingIndex.containsKey(copyArr[i])) {
                existCount++;
                continue;
            }
            valMappingIndex.put(copyArr[i], i + 1 - existCount);
        }

        for (int i = 0; i < arr.length; i++) arr[i] = valMappingIndex.get(arr[i]);
        return arr;
    }
}
