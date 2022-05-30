package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/5/28 11:49 下午
 * @Version 1.0
 */
public class Demo93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> rsp = new ArrayList<>();
        int len;
        if (s == null || (len = s.length()) < 4 || len > 12) return rsp;

        traceBack(rsp, 0, len, new LinkedList<>(), s);

        return rsp;
    }

    private void traceBack(List<String> rsp, int begin, int len, LinkedList<String> ips, String s) {
        if (begin == len) {
            if (ips.size() == 4) {
                rsp.add(String.join(".", ips));
            }
            return;
        }
        // 前面判断剩余字符串长度不够剩余ip个数时，后面判断剩余字符串长度就算每个取三位也存在多余字符
        if (len - begin < (4 - ips.size()) || len - begin > 3 * (4 - ips.size()))
            return;

        for (int i = 0; i < 3; i++) {
            if (begin + i >= len) return;

            String ip = s.substring(begin, begin + i + 1);
            if (ip.length() > 1 && ip.startsWith("0"))
                return;

            int val = Integer.parseInt(ip);
            if (val > 255) return;

            ips.addLast(ip);
            traceBack(rsp, begin + i + 1, len, ips, s);
            ips.removeLast();
        }
    }
}
