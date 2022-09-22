package com.leetcode.weekly.dipingxian.week308;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @Author milindeyu
 * @Date 2022/8/28 10:45 上午
 * @Version 1.0
 */
public class Demo6161 {

    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') sb.deleteCharAt(sb.length() - 1);
            else sb.append(c);
        }
        return sb.toString();
    }
}
