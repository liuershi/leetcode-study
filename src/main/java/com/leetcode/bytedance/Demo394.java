package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/8/13 1:22 下午
 * @Version 1.0
 */
public class Demo394 {

    public String decodeString(String s) {
        // 基于栈实现
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> numberList = new LinkedList<>();
        LinkedList<String> strList = new LinkedList<>();
        int number = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                numberList.addLast(number);
                strList.addLast(sb.toString());
                number = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder subSb = new StringBuilder(strList.removeLast());
                int count = numberList.removeLast();
                for (int i = 0; i < count; i++) {
                    subSb.append(sb);
                }
                sb = subSb;
            } else if (c >= '0' && c <= '9') {
                // 为数字时
                number = number * 10 + (c - '0');
            } else {
                // 为字母时
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Demo394 demo394 = new Demo394();
        System.out.println(demo394.decodeString("3[a]2[bc]"));
    }
}
