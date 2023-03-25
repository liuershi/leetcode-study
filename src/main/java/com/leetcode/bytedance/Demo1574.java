package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/3/25 10:24 下午
 * @Version 1.0
 */
public class Demo1574 {


    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int i = 0, j = n - 1;
        while (i < n - 1 && arr[i + 1] >= arr[i]) {
            i++;
        }
        while (j > 0 && arr[j] >= arr[j - 1]) {
            j--;
        }

        // 说明此时数组是非递减的
        if (i >= j) {
            return 0;
        }

        int ans = Math.min(j, n - 1 - i);
        for (int k = 0; k <= i; k++) {
            int r = binarySearch(arr, arr[k], j);
            ans = Math.min(ans, r - k - 1);
        }
        return ans;
    }

    private int binarySearch(int[] arr, int val, int left) {
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr[mid] >= val) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
