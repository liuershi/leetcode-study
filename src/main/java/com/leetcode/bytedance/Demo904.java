package com.leetcode.bytedance;

/**
 * @author zhangwei151
 * @date 2022/10/17 12:30
 */
public class Demo904 {

    public int totalFruit(int[] fruits) {
        // 思路：双指针
        int max = 1;
        int left = 0, right = 0;
        // 记录当前两个树种的类型
        int x = -1, y = fruits[0];
        // 对应两个树种已经遍历过位置的最大下标
        int xIdx = -1, yIdx = 0;
        // 当前遍历过的树种类型
        int diff = 1;
        while (right < fruits.length) {
            int cur = fruits[right];
            if (cur == x || cur == y) {
                if (cur == x) {
                    // 当当前树与第一课树相同时，则将两个树交换，一定要保证第一个树小于后面的树
                    xIdx = yIdx;
                    yIdx = right;
                    x = y;
                    y = cur;
                } else {
                    yIdx = right;
                }
                max = Math.max(max, right - left + 1);
                right++;
                continue;
            }
            diff++;
            if (diff > 2) {
                // 此时存在超过三种数树的类型
                left = Math.min(xIdx, yIdx) + 1;
                diff = 2;
            }
            x = y;
            y = cur;
            xIdx = yIdx;
            yIdx = right;
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        var demo904 = new Demo904();
        int[] nums = {1,9,1,8,22,0,22,19,19,2,19,6,6,19,2,20,2,9,9,9,9,16,19,16,19,11,19,0,19,19};
        int[] nums1 = {1,1,6,5,6,6,1,1,1,1};
        System.out.println(demo904.totalFruit(nums));
        System.out.println(demo904.totalFruit(nums1));
    }
}
