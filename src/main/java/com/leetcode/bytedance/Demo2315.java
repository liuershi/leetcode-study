package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/1/30 8:01 下午
 * @Version 1.0
 */
public class Demo2315 {

    public int countAsterisks(String s) {
        boolean enablePrefix = false;
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '|') {
                enablePrefix = !enablePrefix;
            } else if (c == '*' && !enablePrefix) {
                cnt++;
            }
        }
        return cnt;
    }
}
