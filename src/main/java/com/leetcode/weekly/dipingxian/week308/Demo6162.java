package com.leetcode.weekly.dipingxian.week308;

/**
 * @Author milindeyu
 * @Date 2022/8/28 11:05 上午
 * @Version 1.0
 */
public class Demo6162 {

    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int mCount = 0, pCount = 0, gCount = 0;
        int lastM = 0, lastP = 0, lastG = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < garbage[i].length(); j++) {
                if (garbage[i].charAt(j) == 'M') {
                    mCount++;
                    lastM = i;
                }
                else if (garbage[i].charAt(j) == 'P') {
                    pCount++;
                    lastP = i;
                }
                else {
                    gCount++;
                    lastG = i;
                }
            }
        }
        for (int i = 1; i < travel.length; i++) {
            travel[i] += travel[i - 1];
        }
        if (lastM > 0) lastM = travel[lastM - 1];
        if (lastP > 0) lastP = travel[lastP - 1];
        if (lastG > 0) lastG = travel[lastG - 1];
        return mCount + pCount + gCount + lastM + lastP + lastG;
    }
}
