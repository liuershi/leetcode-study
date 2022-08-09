package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/16 10:46 上午
 * @Version 1.0
 */
public class Demo2243 {

    public String digitSum(String s, int k) {
        if (s.length() <= k) return s;
        int len = s.length() / k;
        if (s.length() % k != 0) len++;
        String[] ss = new String[len];
        for (int i = 0; i < ss.length; i++) {
            int end = (i + 1) * k;
            if (i == ss.length - 1) end = s.length();
            ss[i] = s.substring(i * k, end);
        }
        StringBuilder sb = new StringBuilder();
        for (String str : ss) {
            int sum = 0;
            for (char c : str.toCharArray()) {
                sum += c - '0';
            }
            sb.append(sum);
        }
        return digitSum(sb.toString(), k);
    }
}
