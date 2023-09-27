package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2023/9/3 3:08 下午
 * @Version 1.0
 */
public class Demo1921 {

    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        // 每只怪兽到达的时间
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            if (dist[i] == 0) {
                return 0;
            }
            times[i] = dist[i] / speed[i];
            if (dist[i] % speed[i] == 0) {
                times[i]--;
            }
        }

        Arrays.sort(times);
        for (int i = 1; i < n; i++) {
            if (i > times[i]) {
                return i;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        int[] dist = {46,33,44,42,46,36,7,36,31,47,38,42,43,48,48,25,28,44,49,47,29,32,30,6,42,9,39,48,22,26,50,34,40,22,10,45,7,43,24,18,40,44,17,39,36};
        int[] speed = {1,2,1,3,1,1,1,1,1,1,1,1,1,1,7,1,1,3,2,2,2,1,2,1,1,1,1,1,1,1,1,6,1,1,1,8,1,1,1,3,6,1,3,1,1};
        System.out.println(new Demo1921().eliminateMaximum(dist, speed));
    }
}
