package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2023/1/12 7:23 下午
 * @Version 1.0
 */
public class Demo1807 {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>(knowledge.size());
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        StringBuilder content = new StringBuilder();
        int prefix = -1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                prefix = i + 1;
            } else if (chars[i] == ')') {
                content.append(map.getOrDefault(s.substring(prefix, i), "?"));
                prefix = -1;
            } else if (prefix == -1){
                content.append(chars[i]);
            }
        }
        return content.toString();
    }
}
