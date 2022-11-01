package com.leetcode.bytedance;

import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/10/29 12:02 上午
 * @Version 1.0
 */
public class Demo1773 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int idx = "type".equals(ruleKey) ? 0 : "color".equals(ruleKey) ? 1 : 2;
        int rsp = 0;
        for (List<String> item : items) {
            if (ruleValue.equals(item.get(idx))) rsp++;
        }
        return rsp;
    }
}
