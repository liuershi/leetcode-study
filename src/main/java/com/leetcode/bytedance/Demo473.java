package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/6/1 11:42 下午
 * @Version 1.0
 */
public class Demo473 {

    public boolean makesquare(int[] matchsticks) {
        // 火柴数量少于4时肯定无法拼成正方形
        int len;
        if (matchsticks == null || (len = matchsticks.length) < 4) return false;

        int sum = Arrays.stream(matchsticks).sum();
        // 火柴总长度无法被4整除时也无法拼成正方形
        if (sum % 4 != 0) return false;

        int sideLen = sum / 4;
        Arrays.sort(matchsticks);
        // 存在最大火柴长度超过边长时直接返回
        if (matchsticks[len - 1] > sideLen) return false;
        // 从大大小排序
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        int[] buckets = new int[4];

        return dfs(0, matchsticks, buckets, sideLen);
    }

    /**
     * 回溯尝试将火柴放入每个桶
     * @param index 当前火柴下标
     * @param matchsticks 火柴集合
     * @param buckets 存放火柴的四个桶集合
     * @param sideLen 正方形边长
     * @return
     */
    private boolean dfs(int index, int[] matchsticks, int[] buckets, int sideLen) {
        // 遍历火柴完成则直接返回成功
        if (index == matchsticks.length) return true;

        for (int i = 0; i < 4; i++) {
            if (matchsticks[index] + buckets[i] > sideLen)
                continue;
            buckets[i] += matchsticks[index];
            if (dfs(index + 1, matchsticks, buckets, sideLen))
                return true;
            buckets[i] -= matchsticks[index];
        }
        return false;
    }
}
