package com.leetcode.bytedance;

/**
 * @author zhangwei151
 * @date 2022/9/25 13:46
 */
public class Demo788 {

    public int rotatedDigits(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (isGoodNumber(i)) res++;
        }
        return res;
    }

    public boolean isGoodNumber(int n) {
        String sn = String.valueOf(n);
        if (sn.contains("3") || sn.contains("4") || sn.contains("7")) return false;
        char[] chars = sn.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0' || chars[i] == '1' || chars[i] == '8') continue;
            if (chars[i] == '2') chars[i] = '5';
            else if (chars[i] == '5') chars[i] = '2';
            else if (chars[i] == '6') chars[i] = '9';
            else chars[i] = '6';
        }
        return !sn.equals(new String(chars));
    }
}
