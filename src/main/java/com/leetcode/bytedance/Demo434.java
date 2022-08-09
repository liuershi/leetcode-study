package com.leetcode.bytedance;

/**
 * @author zhangwei151
 * @date 2022/7/28 15:34
 */
public class Demo434 {

    public int countSegments(String s) {
        int count = 0;
        for (String content : s.split(" ")) {
            if (!"".equals(content.trim())) count++;
        }
        return count;
    }
}
