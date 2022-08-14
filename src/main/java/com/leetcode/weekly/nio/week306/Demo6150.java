package com.leetcode.weekly.nio.week306;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/8/14 11:12 上午
 * @Version 1.0
 */
public class Demo6150 {

    public String smallestNumber(String pattern) {
       int i = 0, n = pattern.length();
       char[] res = new char[n + 1];
       // 初始化的字符
       char cur = '1';
       while (i < n) {
           if (i > 0 && pattern.charAt(i) == 'I') i++;
           for (; i < n && pattern.charAt(i) == 'I'; i++) res[i] = cur++;
           int j = i;
           while (i < n && pattern.charAt(i) == 'D') i++;
           for (int k = i; k >= j; k--) res[k] = cur++;
       }
       return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(new Demo6150().smallestNumber("IIIDIIID"));
    }
}
