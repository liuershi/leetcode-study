package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/1 12:04 上午
 * @Version 1.0
 */
public class Demo1374 {

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if ((n & 1) == 0) {
            for (int i = 0; i < n - 1; i++) {
                sb.append("a");
            }
            sb.append("b");
        } else {
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
        }
        return sb.toString();
    }
}
