package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/8/21 7:40 下午
 * @Version 1.0
 */
public class Offer38 {

    Set<String> res = new HashSet<>();
    char[] chars;
    public String[] permutation(String s) {
        chars = s.toCharArray();
        traceBack(new LinkedList<Integer>());
        return res.toArray(new String[]{});
    }

    private void traceBack(LinkedList<Integer> path) {
        if (path.size() == chars.length) {
            StringBuilder sb = new StringBuilder();
            for (Integer idx : path) {
                sb.append(chars[idx]);
            }
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (path.contains(i)) continue;
            path.addLast(i);
            traceBack(path);
            path.removeLast();
        }
    }
}
