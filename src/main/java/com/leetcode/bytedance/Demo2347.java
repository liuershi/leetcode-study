package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2023/2/20 12:09 上午
 * @Version 1.0
 */
public class Demo2347 {

    public String bestHand(int[] ranks, char[] suits) {
        int n = ranks.length;
        char suit = suits[0];
        Map<Integer, Integer> rankMap = new HashMap<>();
        int sameMax = 0;
        for (int i = 0; i < n; i++) {
            if (suit != 'e' && suit != suits[i]) {
                suit = 'e';
            }
            rankMap.put(ranks[i], rankMap.getOrDefault(ranks[i], 0) + 1);
            sameMax = Math.max(sameMax, rankMap.get(ranks[i]));
        }

        if (suit != 'e') {
            return "Flush";
        } else if (sameMax >= 3) {
            return "Three of a Kind";
        } else if (sameMax == 2) {
            return "Pair";
        } else {
            return "High Card";
        }
    }
}
