package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/9/12 10:46 下午
 * @Version 1.0
 */
public class Demo852 {

    public int peakIndexInMountainArray(int[] arr) {
//        return method1(arr);
        // 思路二：二分法查询，根据当前值跟前后值比较决定移动的方向
        // 时间复杂度：O(n)
        // 注意：由于存在山峰，所以必不可能在边界出现山峰的情况，此时直接将
        // 左右边界直接移动一位，避免边界判断错误
        int left = 1, right = arr.length - 2;
        while (left < right) {
            int middle = left + ((right - left) >> 1);
            if (arr[middle] < arr[middle + 1]) left = middle + 1;
            else if (arr[middle] > arr[middle - 1] && arr[middle] > arr[middle + 1]) return middle;
            else right = middle - 1;
        }
        return -1;
    }

    private int method1(int[] arr) {
        // 思路一：遍历
        // 时间复杂度：O(n)
        if (arr.length < 3) return -1;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) return i;
        }
        return -1;
    }
}
