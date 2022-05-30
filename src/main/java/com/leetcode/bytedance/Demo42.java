package com.leetcode.bytedance;


/**
 * @Author milindeyu
 * @Date 2022/3/20 1:05 下午
 * @Version 1.0
 */
public class Demo42 {
    public int trap(int[] height) {
        int result = 0;
        int length = height.length;
        if (length < 3) {
            return result;
        }
        int max = 0;
        int maxIdx = 0;
        // 拿到最大点下标
        for (int i = 0; i < length; i++) {
            max = Math.max(height[i], max);
            if (max == height[i]) {
                maxIdx = i;
            }
        }
        // 左边部分
        for (int i = 0; i < maxIdx; i++) {
            for (int j = i + 1; j <= maxIdx; j++) {
                if (height[j] < height[i]) {
                    result += height[i] - height[j];
                } else {
                    i = j;
                }
            }
        }
        // 右边部分
        for (int i = length - 1; i >= maxIdx; i--) {
            for (int j = i - 1; j >= maxIdx; j--) {
                if (height[j] < height[i]) {
                    result += height[i] - height[j];
                } else {
                    i = j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Demo42 demo42 = new Demo42();
        int[] ints = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(demo42.trap(ints));
    }
}
