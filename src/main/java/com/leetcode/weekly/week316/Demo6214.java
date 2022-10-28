package com.leetcode.weekly.week316;

/**
 * @Author milindeyu
 * @Date 2022/10/23 10:31 上午
 * @Version 1.0
 */
public class Demo6214 {

    public boolean haveConflict(String[] event1, String[] event2) {
        String[] startTime1 = event1[0].split(":");
        String[] endTime1 = event1[1].split(":");
        String[] startTime2 = event2[0].split(":");
        String[] endTime2 = event2[1].split(":");
        int startTimeVal1 = Integer.parseInt(startTime1[0]) * 60 + Integer.parseInt(startTime1[1]);
        int endTimeVal1 = Integer.parseInt(endTime1[0]) * 60 + Integer.parseInt(endTime1[1]);
        int startTimeVal2 = Integer.parseInt(startTime2[0]) * 60 + Integer.parseInt(startTime2[1]);
        int endTimeVal2 = Integer.parseInt(endTime2[0]) * 60 + Integer.parseInt(endTime2[1]);
        return !(endTimeVal1 < startTimeVal2 || startTimeVal1 > endTimeVal2);
    }
}
