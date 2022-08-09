package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * 有序队列
 *
 * @Author milindeyu
 * @Date 2022/8/3 10:39 下午
 * @Version 1.0
 */
public class Demo899 {

    public String orderlyQueue(String s, int k) {
        String rsp = s;
        if (k == 1) {
            for (int i = 0; i < s.length(); i++) {
                String nextStr = s.substring(i + 1) + s.substring(0, i + 1);
                rsp = nextStr.compareTo(rsp) < 0 ? nextStr : rsp;
            }
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            rsp = new String(chars);
        }
        return rsp;
    }
}
