package com.leetcode.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author milindeyu
 * @Date 2022/7/7 9:53 下午
 * @Version 1.0
 */
public class TestHashMap {
    public static void main(String[] args) {
        Map<String, String> ma = new HashMap<>(33);
        ma.put("1", "!");

        ConcurrentHashMap<String, String> stringStringConcurrentHashMap = new ConcurrentHashMap<>(11);
    }
}
