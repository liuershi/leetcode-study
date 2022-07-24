package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/7/23 4:53 下午
 * @Version 1.0
 */
public class Demo139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        int sl = s.length();
        boolean[] memo = new boolean[sl + 1];
        memo[0] = true;

        for (int i = 1; i <= sl; i++) {
            for (int j = 0; j < i; j++) {
                if (memo[j] && set.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[sl];
    }
}
