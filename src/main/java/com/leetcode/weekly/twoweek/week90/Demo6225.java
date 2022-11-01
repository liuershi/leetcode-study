package com.leetcode.weekly.twoweek.week90;

import com.leetcode.zcy.graph.Node;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author milindeyu
 * @Date 2022/10/29 10:33 下午
 * @Version 1.0
 */
public class Demo6225 {

    public static String oddString(String[] words) {
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
           }
           set.put(nums, word);
        }

        for (Map.Entry<int[], String> entry : set.entrySet()) {
            if (!Arrays.equals(entry.getKey(), arr))
                return entry.getValue();
        }
        return null;
    }

    public static void main(String[] args) {
        String[] words = {"wwe","yyg","ssa","ttb","ddd","ssa","xxf","ssa","ttb","xxf","xxf","zzh","wwe","yyg","xxf"};
        System.out.println(oddString(words));
    }
}
