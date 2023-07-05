package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/5/17 10:11 下午
 * @Version 1.0
 */
public class Demo2446 {

    public boolean haveConflict(String[] event1, String[] event2) {
        int startTime1 = timeToSeconds(event1[0]),
                endTime1 = timeToSeconds(event1[1]);
        int startTime2 = timeToSeconds(event2[0]),
                endTime2 = timeToSeconds(event2[1]);
        return !(endTime1 < startTime2 || endTime2 < startTime1);
    }

    private int timeToSeconds(String time) {
        return Integer.parseInt(time.split(":")[0]) * 60
                + Integer.parseInt(time.split(":")[1]);
    }
}
