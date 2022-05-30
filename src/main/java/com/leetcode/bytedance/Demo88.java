package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/5/28 9:54 下午
 * @Version 1.0
 */
public class Demo88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        method01(nums1, m, nums2, n);

        method2(nums1, m, nums2, n);

        method3(nums1, m, nums2, n);
    }

    /**
     * 方法三：是方法二上空间复杂度的优化，在方法二中，使用一个 m + n 大小的新数组存放排序后的元素，
     * 这是因为若直接放如数组num1中，则可能未排序的元素被覆盖，在方法三中，我们从后向前遍历，每次取最大
     * 值放入数组num1的后面，这样不会存在被覆盖的情况
     *      时间复杂度：O(m+n)
     *      空间复杂度：O(1)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    private void method3(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int cur, l1 = m - 1, l2 = n - 1;
        while (l1 >= 0 || l2 >= 0) {
            if (l1 < 0) {
                cur = nums2[l2--];
            } else if (l2 < 0) {
                cur = nums1[l1--];
            } else if (nums1[l1] > nums2[l2]) {
                cur = nums1[l1--];
            } else {
                cur = nums2[l2--];
            }
            nums1[index--] = cur;
        }
    }

    /**
     * 方法二：使用两个数组已经排序的特性，分别遍历比较大小放入新的数组中，以达到最终排序完成的特性
     *      时间复杂度：O(m+n)
     *      空间复杂度：O(m+n)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    private void method2(int[] nums1, int m, int[] nums2, int n) {
        int[] sort = new int[m + n];
        int cur, l1 = 0, l2 = 0;
        while (l1 < m || l2 < n) {
            if (l1 == m) {
                cur = nums2[l2++];
            } else if (l2 == n) {
                cur = nums1[l1++];
            } else if (nums1[l1] > nums2[l2]) {
                cur = nums2[l2++];
            } else {
                cur = nums1[l1++];
            }
            sort[l1 + l2 - 1] = cur;
        }
        for (int i = 0; i < sort.length; i++) {
            nums1[i] = sort[i];
        }
    }


    /**
     * 方法一：将数组num2的值全部复制到num1的尾部，再排序
     *      时间复杂度：等同于长度为m+n的数组快速排序，时间复杂度 O((m+n)log(m+n))
     *      空间复杂度：O(log(m+n))
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    private void method01(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
