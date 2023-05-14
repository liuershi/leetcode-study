package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/4/1 2:33 下午
 * @Version 1.0
 */
public class Demo831 {

    public String maskPII(String s) {
        int mailSeparator;
        if ((mailSeparator = s.indexOf("@")) == -1) {
            // 为电话号码
            int digitNum = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--) {
                if (Character.isDigit(s.charAt(i))) {
                    if (digitNum < 4) {
                        sb.append(s.charAt(i));
                    }
                    digitNum++;
                }
            }
            String suffix = sb.reverse().toString();
            if (digitNum == 10) {
                return "***-***-" + suffix;
            } else if (digitNum == 11) {
                return "+*-***-***-" + suffix;
            } else if (digitNum == 12) {
                return "+**-***-***-" + suffix;
            } else {
                return "+***-***-***-" + suffix;
            }
        } else {
            String prefix = s.substring(0, mailSeparator).toLowerCase(),
                    suffix = s.substring(mailSeparator + 1).toLowerCase();
            if (prefix.length() > 1) {
                prefix = prefix.charAt(0) + "*****" + prefix.charAt(prefix.length() - 1);
            }
            return prefix + "@" + suffix;
        }
    }
}
