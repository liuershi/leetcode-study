package com.leetcode.weekly.twoweek.week89;

/**
 * @Author milindeyu
 * @Date 2022/10/15 10:30 下午
 * @Version 1.0
 */
public class Demo6208 {

    public int countTime(String time) {
        int rsp = 1;
        if (time.contains("?")) {
            String[] strs = time.split(":");
            if (strs[0].equals("??")) rsp = 24;
            else if (strs[0].charAt(0) == '?') {
                if (strs[0].charAt(1) < '4') rsp = 3;
                else rsp = 2;
            } else if (strs[0].charAt(1) == '?') {
                if (strs[0].charAt(0) < '2') rsp = 10;
                else rsp = 4;
            }

            if (strs[1].equals("??")) rsp *= 60;
            else if (strs[1].charAt(0) == '?') rsp *= 6;
            else if (strs[1].charAt(1) == '?') rsp *= 10;
        }
        return rsp;
    }
}
