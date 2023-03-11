package com.leetcode.mianshi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2023/3/11 12:54 下午
 * @Version 1.0
 */
public class Demo1705 {

    public String[] findLongestSubarray(String[] array) {
        int len;
        if (array == null || (len = array.length) == 0) {
            return new String[]{};
        }
        int[] prefixSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + isDigit(array[i].charAt(0)) * 2 - 1;
        }

        int begin = 0, end = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= len; i++) {
            int j = map.getOrDefault(prefixSum[i], -1);
            if (j < 0) {
                map.put(prefixSum[i], i);
            } else if (i - j > end - begin) {
                begin = j;
                end = i;
            }
        }

        return Arrays.copyOfRange(array, begin, end + 1);
    }

    private int isDigit(char c) {
        return Character.isDigit(c) ? 1 : 0;
    }


    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(300));
    }
}
