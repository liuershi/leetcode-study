package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author milindeyu
 * @Date 2022/7/24 12:19 上午
 * @Version 1.0
 */
public class Demo151 {

    public String reverseWords(String s) {
        List<String> rsp = Arrays.stream(s.trim().split(" ")).filter(str -> !"".equals(str.trim())).collect(Collectors.toList());
        Collections.reverse(rsp);
        return String.join(" ", rsp);
    }
}
