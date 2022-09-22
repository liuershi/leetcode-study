package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/8/25 11:08 下午
 * @Version 1.0
 */
public class Demo658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        return method1(arr, k, x);
        // 排除法
        List<Integer> res = new ArrayList<>(k);
        int n = arr.length;
        int left = 0, right = n - 1;
        // 由于要保留k个数，故可理解为从arr中删除（n - k）个数
        int removeElementSize = n - k;
        while (removeElementSize > 0) {
            // 此时左边的数更加合适，所以移除右边的数
            if (x - arr[left] <= arr[right] - x) {
                right--;
            } else left++;
            removeElementSize--;
        }
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    /**
     * 基于二分查询和双指针
     *    问题：各种边界问题需要考虑
     * @param arr
     * @param k
     * @param x
     * @return
     */
    private LinkedList<Integer> method1(int[] arr, int k, int x) {
        LinkedList<Integer> res = new LinkedList<>();
        int n = arr.length;
        if (x <= arr[0] || x >= arr[n - 1]) {
            int start = x <= arr[0] ? 0 : n - k;
            for (int i = start; i < start + k; i++) {
                res.add(arr[i]);
            }
        } else {
            // 先二分查询查到对应的数
            int right = binarySearch(arr, x);
            // 从当前查询到的下标向两边扩散
            int left = right - 1;
            while (res.size() != k) {
                if (left < 0) res.addLast(arr[right++]);
                else if (right >= n) res.addFirst(arr[left--]);
                else if (x - arr[left] <= arr[right] - x) res.addFirst(arr[left--]);
                else res.addLast(arr[right++]);
            }
        }
        return res;
    }

    public int binarySearch(int[] nums, int x) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] >= x) {
                right = middle;
            } else left = middle + 1;
        }
        return left;
    }
}
