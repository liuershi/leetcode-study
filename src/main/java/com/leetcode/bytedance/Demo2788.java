package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2024/1/20 12:39 上午
 * @Version 1.0
 */
public class Demo2788 {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            String[] ss = word.split(String.valueOf(separator));
            if (ss.length > 0) {
                for (int i = 0; i < ss.length; i++) {
                    if (!ss[i].isEmpty()) {
                        ans.add(ss[i]);
                    }
                }
            }
        }
        return ans;
    }
}
