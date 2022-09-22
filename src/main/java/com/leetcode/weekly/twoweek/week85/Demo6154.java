package com.leetcode.weekly.twoweek.week85;

/**
 * @Author milindeyu
 * @Date 2022/8/20 10:42 下午
 * @Version 1.0
 */
public class Demo6154 {

    public int secondsToRemoveOccurrences(String s) {
        int len = s.length();
        if (len < 2) return 0;
        int res = 0;
        while (s.contains("01")) {
            s = s.replace("01", "10");
            res++;
        }
        return res;
    }
}
