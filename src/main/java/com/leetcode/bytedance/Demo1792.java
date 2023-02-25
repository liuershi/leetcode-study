package com.leetcode.bytedance;

import java.util.PriorityQueue;

/**
 * @Author milindeyu
 * @Date 2023/2/19 2:18 下午
 * @Version 1.0
 */
public class Demo1792 {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> queue = new PriorityQueue<double[]>(
                classes.length,
                (a, b) -> {
                    // 分别计算两个班级的通过率增量
                    double incrA = (a[0] + 1) / (a[1] + 1) - a[0] / a[1];
                    double incrB = (b[0] + 1) / (b[1] + 1) - b[0] / b[1];
                    return Double.compare(incrB, incrA);
                }
        );

        for (int[] aClass : classes) {
            queue.offer(new double[]{aClass[0], aClass[1]});
        }

        while (extraStudents-- > 0) {
            double[] element = queue.poll();
            element[0]++;
            element[1]++;
            queue.offer(element);
        }

        double res = 0;
        while (!queue.isEmpty()) {
            double[] element = queue.poll();
            res += element[0] / element[1];
        }

        res /= classes.length;

        return res;
    }
}
