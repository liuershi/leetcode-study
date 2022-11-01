package com.leetcode.weekly.twoweek.week90;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/10/29 11:03 下午
 * @Version 1.0
 */
public class Demo6228 {

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> rsp = new ArrayList<>();
        int len = queries[0].length();
        for (String query : queries) {
            for (String content : dictionary) {
                int diff = 0;
                for (int i = 0; i < len; i++) {
                    if (query.charAt(i) != content.charAt(i)) {
                        if (++diff > 2)
                            break;
                    }
                }
                if (diff <= 2) {
                    rsp.add(query);
                    break;
                }
            }
        }
        return rsp;
    }
}
