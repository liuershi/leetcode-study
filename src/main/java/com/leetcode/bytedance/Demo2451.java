package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2023/5/25 12:21 上午
 * @Version 1.0
 */
public class Demo2451 {

    public String oddString(String[] words) {
        int n = words[0].length() - 1;
        TreeMap<int[], String> set = new TreeMap<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Arrays.equals(o1, o2) ? 0 : 1;
            }
        });
        int[] arr = null;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int[] nums = new int[n];
            for (int j = 1; j <= n; j++) {
                nums[j - 1] = word.charAt(j) - word.charAt(j - 1);
            }
            if (set.containsKey(nums)) {
                arr = nums;
            } else set.put(nums, word);
        }

        for (Map.Entry<int[], String> entry : set.entrySet()) {
            if (!Arrays.equals(entry.getKey(), arr))
                return entry.getValue();
        }
        return null;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"adc","wzy","abc"};
        System.out.println(new Demo2451().oddString(strs));
    }
}
