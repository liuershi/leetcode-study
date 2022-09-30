package com.leetcode.bytedance;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author milindeyu
 * @Date 2022/10/1 12:36 上午
 * @Version 1.0
 */
public class Demo451 {

    public String frequencySort(String s) {
//        return method1(s);
        // 思路二：分割字符串分组
        return Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    if (o1.getKey().equals(o2.getKey()))
                        return o2.getValue().compareTo(o1.getValue());
                    else return o2.getValue().compareTo(o1.getValue());
                })
                .map(entry -> {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < entry.getValue(); i++) {
                        sb.append(entry.getKey());
                    }
                    return sb.toString();
                }).collect(Collectors.joining());


    }

    private String method1(String s) {
        // 思路：遍历字符，map存放各字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        map.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .forEach(entry -> {
                    for (int i = 0; i < entry.getValue(); i++) {
                        sb.append(entry.getKey());
                    }
                });
        return sb.toString();
    }
}
