package com.leetcode.weekly.yinlian.week293;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * https://leetcode.cn/contest/weekly-contest-293/problems/find-resultant-array-after-removing-anagrams/
 *
 * @Author milindeyu
 * @Date 2022/8/10 10:08 下午
 * @Version 1.0
 */
public class Demo2273 {

    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>(words.length);
        int len = words.length;
        if (len == 1) {
            res.add(words[0]);
            return res;
        }
        for (int i = len - 1; i >= 1; i--) {
            char[] next = words[i - 1].toCharArray(), cur = words[i].toCharArray();
            Arrays.sort(next);
            Arrays.sort(cur);
            if (!Arrays.equals(next, cur)) {
                res.add(words[i]);
            }
        }
        res.add(words[0]);
        Collections.reverse(res);
        return res;
    }
}
