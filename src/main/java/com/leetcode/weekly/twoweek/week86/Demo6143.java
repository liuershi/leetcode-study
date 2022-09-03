package com.leetcode.weekly.twoweek.week86;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author milindeyu
 * @Date 2022/9/3 11:44 下午
 * @Version 1.0
 */
public class Demo6143 {

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;

        int[] memo = new int[n];
        memo[0] = runningCosts[0];
        for (int i = 1; i < n; i++) {
            memo[i] = memo[i - 1] + runningCosts[i];
        }

        int maxChargeTime = 0, startIndex = 0, res = 0;
        long  sumRunningCosts;
        for (int i = 0; i < n; i++) {
            if (chargeTimes[i] + runningCosts[i] <= budget) res = Math.max(res, 1);
            for (int j = startIndex; j <= i; j++) {
                maxChargeTime = Math.max(chargeTimes[j], chargeTimes[i]);
            }
            sumRunningCosts = (long) (i - startIndex + 1) * (memo[i] - memo[startIndex] + runningCosts[startIndex]);
            if (maxChargeTime + sumRunningCosts <= budget) {
                res = Math.max(res, i - startIndex + 1);
            } else {
                startIndex++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Demo6143 demo6143 = new Demo6143();
        int[] chargeTimes = {32,83,96,70,98,80,30,42,63,67,49,10,80,13,69,91,73,10};
        int[] runningCosts = {49,67,92,26,18,22,38,34,36,26,32,84,39,42,88,51,8,2};
        int budget = 599;
        System.out.println(demo6143.maximumRobots(chargeTimes, runningCosts, budget));
    }
}
