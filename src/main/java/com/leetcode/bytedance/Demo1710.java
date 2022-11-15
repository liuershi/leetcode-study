package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/11/15 10:11 下午
 * @Version 1.0
 */
public class Demo1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);
        int rsp = 0, idx = 0;
        while (truckSize > 0 && idx < boxTypes.length) {
            rsp += Math.min(truckSize, boxTypes[idx][0]) * boxTypes[idx][1];
            truckSize -= boxTypes[idx][0];
            idx++;
        }
        return rsp;
    }
}
