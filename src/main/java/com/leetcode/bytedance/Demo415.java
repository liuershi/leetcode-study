package com.leetcode.bytedance;

/**
 * @author zhangwei151
 * @date 2022/7/28 15:28
 */
public class Demo415 {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length() - 1, len2 = num2.length() - 1, prev = 0;
        while (len1 >= 0 || len2 >= 0 || prev != 0) {
            if (len1 > 0) prev += num1.charAt(len1--) - '0';
            if (len2 > 0) prev += num2.charAt(len2--) - '0';
            sb.insert(0, prev % 10);
            prev /= 10;
        }
        return sb.toString();
    }
}
