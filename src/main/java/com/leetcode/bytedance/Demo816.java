package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/11/7 10:24 下午
 * @Version 1.0
 */
public class Demo816 {

    public List<String> ambiguousCoordinates(String s) {
        List<String> rsp = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        int len = s.length();
        for (int i = 1; i < len; i++) {
            String start = s.substring(0, i), end = s.substring(i, len);
            List<String> startList = process(start);
            List<String> endList = process(end);
            if (startList.isEmpty() || endList.isEmpty())
                continue;
            for (String prefix : startList) {
                for (String suffix : endList) {
                    rsp.add("(" + prefix + ", " + suffix + ")");
                }
            }
        }
        return rsp;
    }

    private List<String> process(String content) {
        if (content.length() == 1)
            return Collections.singletonList(content);
        // 校验content是否符合规则
        if (Integer.parseInt(content) == 0) return Collections.emptyList();
        if (content.charAt(0) == '0' && content.charAt(content.length() - 1) == '0') return Collections.emptyList();
        else if (content.charAt(0) == '0') {
            return Collections.singletonList("0." + content.substring(1));
        } else if (content.charAt(content.length() - 1) == '0') {
            return Collections.singletonList(content);
        } else {
            List<String> rsp = new ArrayList<>();
            rsp.add(content);
            for (int i = 1; i < content.length(); i++) {
                rsp.add(content.substring(0, i) + "." + content.substring(i));
            }
            return rsp;
        }
    }
}
