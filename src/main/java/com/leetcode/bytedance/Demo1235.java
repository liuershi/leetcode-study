package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * @Author milindeyu
 * @Date 2022/10/22 2:42 下午
 * @Version 1.0
 */
public class Demo1235 {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // 思路：
        // 1.先将所有工作按照结束时间从小到大排序
        // 2.用dp[i]表达当前i前面的i - 1个工作的最大报酬，所以dp[0]= 0
        // 3.得到转换方程，即：dp[i] = Math.max(dp[i - 1), dp[k] + profit[i - 1])，
        // k为当前结束时间小于等于 i - 1 个工作的开始时间的那个工作，所以可以理解为当前工作的最大值为前一个做工作的最大值与前一个工作未有时间
        // 交集的工作加上前一个工作的报酬取最大值
        // 4.k值的获取可以通过二分法查询
        int len = startTime.length;
        int[][] jobs = new int[len][];
        IntStream.range(0, len).forEach(i -> jobs[i] = new int[]{startTime[i], endTime[i], profit[i]});
        // 按结束时间从小到大排序
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            int k = binarySearch(jobs, i - 1, jobs[i - 1][0]);
            dp[i] = Math.max(dp[i - 1], jobs[i - 1][2] + dp[k]);
        }
        return dp[len];
    }

    /**
     * 二分法查询最接近开始时间为target的的前面的工作
     * @param jobs 开始、结束、报酬的数组
     * @param right 目标工作的最右边界
     * @param target 最右数组的开始时间
     * @return
     */
    private int binarySearch(int[][] jobs, int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
