package com.leetcode.weekly.week316;

import java.util.LinkedList;

/**
 * @Author milindeyu
 * @Date 2022/10/23 10:49 上午
 * @Version 1.0
 */
public class Demo6224 {

    public int subarrayGCD(int[] nums, int k) {
        // 思路：暴力
        int rsp = 0;
        for (int i = 0; i < nums.length; i++) {
            int g = nums[i];
            for (int j = i; j < nums.length; j++) {
                g = euclidean_algorithm(g, nums[j]);
                if (g == k) rsp++;
                else if (g < k)break;
            }
        }
        return rsp;
    }

    public static int  euclidean_algorithm(int a, int b){
        if(b==0){
            return a;}
        return euclidean_algorithm(b,a%b);
    }
}
