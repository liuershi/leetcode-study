package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/8/15 11:22 下午
 * @Version 1.0
 */
public class Offer48 {

    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        if (s == null || (len = s.length()) < 2) return len;

        Map<Character, Integer> container = new HashMap<>(len);
        int res = 0;
        for (int left = 0, right = 0; right < len; right++) {
            char item = s.charAt(right);
            // 当容器中包含当前元素时，则取当前left和重复元素右一位下标较大值设为left
            if (container.containsKey(item)) {
                left = Math.max(left, container.get(item) + 1);
            }
            res  = Math.max(res, right - left + 1);
            container.put(item, right);
        }
        return res;
    }
}
