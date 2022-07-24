package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/23 8:40 下午
 * @Version 1.0
 */
public class Demo405 {

    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        String hex = "0123456789abcdef";
        while (num != 0 && sb.length() < 8) {
            char val = hex.charAt(num & 0xf);
            sb.insert(0, val);
            num >>= 4;
        }
        return sb.toString();
    }
}
