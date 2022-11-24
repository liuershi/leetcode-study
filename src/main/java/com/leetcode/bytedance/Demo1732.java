package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/11/19 4:43 下午
 * @Version 1.0
 */
public class Demo1732 {

    public int largestAltitude(int[] gain) {
        int rsp = 0, cur = 0;
        for (int i = 0; i < gain.length; i++) {
            cur += gain[i];
            rsp = Math.max(rsp, cur);
        }
        return rsp;
    }
}
