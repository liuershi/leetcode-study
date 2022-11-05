package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/11/6 12:39 上午
 * @Version 1.0
 */
public class Demo1678 {

    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        char[] chars = command.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'G')
                sb.append(chars[i]);
            else if (chars[i] == ')')
                sb.append(chars[i - 1] == '(' ? "o" : "al");
        }
        return sb.toString();
    }
}
