package com.leetcode.bytedance;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author milindeyu
 * @Date 2022/6/26 3:01 下午
 * @Version 1.0
 */
public class Demo710 {

    class Solution {
        Map<Integer, Integer> blackToWhile;
        Random random;
        int bound;

        public Solution(int n, int[] blacklist) {
            blackToWhile = new HashMap<>();
            random = new Random();

            Set<Integer> set = new HashSet<>();
            bound = n - blacklist.length;
            for (int black : blacklist) {
                if (black >= bound) set.add(black);
            }

            int w = bound;
            for (int black : blacklist) {
                if (black < bound) {
                    while (set.contains(w)) ++w;
                    blackToWhile.put(black, w++);
                }
            }
        }

        public int pick() {
            int i = random.nextInt(bound);
            return blackToWhile.getOrDefault(i, i);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(10));
        }
    }
}
