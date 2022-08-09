package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/19 11:38 下午
 * @Version 1.0
 */
public class Demo134 {

    /**
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int leftAreaSum = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) leftAreaSum += gas[i - 1] - cost[i - 1];
            if (gas[i] == 0) continue;
            int sum = 0, index = i;
            while (sum >= 0 && index < n) {
                sum += gas[index] - cost[index];
                ++index;
            }
            if (index == n && (sum + leftAreaSum) >= 0) return i;
            if (index > i) {
                for (int j = i; j < index - 1; j++) {
                    leftAreaSum += gas[i] - cost[i];
                }
                i = index - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{2,3,4}, new int[]{3, 4, 3}));
    }
}
