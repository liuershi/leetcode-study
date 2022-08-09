package com.leetcode.bytedance;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/7/30 4:37 下午
 * @Version 1.0
 */
public class Demo771 {

    public int numJewelsInStones(String jewels, String stones) {
//        return method01(jewels, stones);
        // 基于数组实现
        int[] upper = new int[26];
        int[] lower = new int[26];
        for (int i = 0; i < jewels.length(); i++) {
            if (Character.isLowerCase(jewels.charAt(i))) lower[jewels.charAt(i) - 'a']++;
            else upper[jewels.charAt(i) - 'A']++;
        }

        int rsp = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (Character.isLowerCase(stones.charAt(i)) && lower[stones.charAt(i) - 'a'] != 0) rsp++;
            if (Character.isUpperCase(stones.charAt(i)) && upper[stones.charAt(i) - 'A'] != 0) rsp++;
        }
        return rsp;
    }

    private int method01(String jewels, String stones) {
        Set<Character> jewelsSet = new HashSet<>(jewels.length());
        for (char c : jewels.toCharArray()) {
            jewelsSet.add(c);
        }

        int rsp = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewelsSet.contains(stones.charAt(i))) rsp++;
        }
        return rsp;
    }
}
