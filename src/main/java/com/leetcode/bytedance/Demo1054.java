package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author milindeyu
 * @Date 2023/5/14 12:56 上午
 * @Version 1.0
 */
public class Demo1054 {

    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> container = new HashMap<>();
        for (int barcode : barcodes) {
            container.put(barcode, container.getOrDefault(barcode, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (Map.Entry<Integer, Integer> entry : container.entrySet()) {
            queue.offer(new int[]{entry.getValue(), entry.getKey()});
        }

        int len = barcodes.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int[] item = queue.poll();
            int count = item[0], key = item[1];
            if (i == 0 || ans[i - 1] != key) {
                ans[i] = key;
                if (count > 1) {
                    queue.offer(new int[]{count - 1, key});
                }
            } else {
                int[] item2 = queue.poll();
                int count2 = item2[0], key2 = item2[1];
                ans[i] = key2;
                if (count > 1) {
                    queue.offer(new int[]{count2 - 1, key2});
                }
                queue.offer(new int[]{count, key});
            }
        }
        return ans;
    }
}
