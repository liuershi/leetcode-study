package com.leetcode.weekly.nio.week300;

import java.util.HashMap;
import java.util.Map;

/**
 * 解密消息
 *
 * @Author milindeyu
 * @Date 2022/8/8 11:09 下午
 * @Version 1.0
 */
public class Demo2325 {

    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>(26);
        int index = 0;
        for (char c : key.toCharArray()) {
            if (c == ' ') continue;
            Character absent = map.putIfAbsent(c, (char) (index + 'a'));
            if (absent == null) index++;
        }
        StringBuilder sb = new StringBuilder(message.length());
        for (int i = 0; i < message.length(); i++) {
            sb.append(map.getOrDefault(message.charAt(i), message.charAt(i)));
        }
        return sb.toString();
    }
}
