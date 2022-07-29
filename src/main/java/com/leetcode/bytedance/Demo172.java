package com.leetcode.bytedance;

import java.math.BigDecimal;

/**
 * @author zhangwei151
 * @date 2022/7/28 16:35
 */
public class Demo172 {
    public int trailingZeroes(int n) {
        if (n == 0) return 0;
//        String[] cache = new String[n + 1];
//        String multiply = helper(n, cache);
        String multiply = "1";
        while (n > 1) {
            multiply = new BigDecimal(multiply).multiply(new BigDecimal(n)).toString();
            n--;
        }

        int rsp = 0;
        for (int i = multiply.length() - 1; i >= 0; i--) {
            if (multiply.charAt(i) != '0') break;
            rsp++;
        }
        return rsp;
    }

    public String helper(int val, String[] cache) {
        if (val < 2) return String.valueOf(val);
        if (cache[val] != null) return cache[val];
        String prev;
        if (cache[val - 1] != null) prev = cache[val - 1];
        else prev = helper(val - 1, cache);
        cache[val] = new BigDecimal(val).multiply(new BigDecimal(prev)).toString() ;
        return cache[val];
    }

    public static void main(String[] args) {
        System.out.println(new Demo172().trailingZeroes(9999));
    }
}
