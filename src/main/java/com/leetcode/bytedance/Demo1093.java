package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/5/27 5:31 下午
 * @Version 1.0
 */
public class Demo1093 {

    public double[] sampleStats(int[] count) {
        int min = -1, max = 0;
        long sum = 0, size = 0;
        int mode = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            if (min == -1) {
                min = i;
            }
            max = i;
            sum += (long) i * count[i];
            size += count[i];
            if (count[i] > count[mode]) {
                mode = i;
            }
        }


        int i = 0, j = 255;
        // 从左边删除最多 (n-1)/2 个数
        for (int t = (int) size - 1 >> 1; t >= count[i]; t -= count[i++]) ;
        // 从右边删除最多 (n-1)/2 个数
        for (int t = (int) size - 1 >> 1; t >= count[j]; t -= count[j--]) ;

        double median = (double) (i + j) / 2;

        return new double[]{min, max, (double) sum / size, median, mode};
    }
}
