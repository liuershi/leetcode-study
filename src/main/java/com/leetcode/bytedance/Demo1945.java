package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/12/15 10:44 下午
 * @Version 1.0
 */
public class Demo1945 {

    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            sb.append(c - 'a' + 1);
        }

        String digit = sb.toString();
        for (int i = 0; i < k && digit.length() > 1; i++) {
            int sum = 0;
            for (int j = 0; j < digit.length(); j++) {
                sum += digit.charAt(j) - '0';
            }
            digit = String.valueOf(sum);
        }
        return Integer.parseInt(digit);
    }
}
