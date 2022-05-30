package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/29 12:10 上午
 * @Version 1.0
 */
public class Demo468 {

    public String validIpAddress(String queryIP) {
        if (queryIP == null) return "Neither";
        // IPV4校验 @see https://www.cnblogs.com/moris5013/p/12989295.html
        String ipv4Regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        if (queryIP.matches(ipv4Regex)) return "IPv4";
        // ipv6校验
        String ipv6Regex = "^[0-9 a-f A-F]{1,4}(:[0-9 a-f A-F]{1,4}){7}";
        if (queryIP.matches(ipv6Regex)) return "IPv6";
        return "Neither";
    }
}
