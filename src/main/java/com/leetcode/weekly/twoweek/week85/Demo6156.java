package com.leetcode.weekly.twoweek.week85;

/**
 * @Author milindeyu
 * @Date 2022/8/20 10:32 下午
 * @Version 1.0
 */
public class Demo6156 {

    public int minimumRecolors(String blocks, int k) {
        int len = blocks.length();
        int min = k, count = 0;
        for (int left = 0, right = 0; right < len; right++) {
            if (blocks.charAt(right) =='W') {
                count++;
            }
            if (right - left + 1 == k) {
                min = Math.min(min, count);
                if (blocks.charAt(left++) == 'W') {
                    count--;
                }
            }
        }
        return min;
    }


}
