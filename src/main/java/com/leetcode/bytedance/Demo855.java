package com.leetcode.bytedance;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author milindeyu
 * @Date 2022/12/30 7:16 下午
 * @Version 1.0
 */
public class Demo855 {

    class ExamRoom {

        PriorityQueue<int[]> queue;
        int[] range;

        public ExamRoom(int n) {
            this.range = new int[n];
            queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] - o1[0] == o2[1] - o2[0])
                        return o1[0] - o2[0];
                    else
                        return (o1[1] - o1[0]) - (o2[1] - o2[0]);
                }
            });
        }

        public int seat() {
            if (queue.isEmpty()) {
                range[0] = 1;
                queue.offer(new int[]{1, range.length - 1});
                return 0;
            } else {
                int[] last = queue.poll();
                if (last[0] == last[1]) {
                    range[last[0]] = 1;
                    return last[0];
                } else {
                    int mid = (last[0] + last[1]) / 2;
                    range[mid] = 1;
                    queue.offer(new int[]{last[0], mid - 1});
                    queue.offer(new int[]{mid + 1, last[1]});
                    return mid;
                }
            }
        }

        public void leave(int p) {

        }
    }
}
