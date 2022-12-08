package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/12/7 9:40 下午
 * @Version 1.0
 */
public class Demo1775 {

    public int minOperations(int[] nums1, int[] nums2) {

        int len1 = nums1.length, len2 = nums2.length;
        if (len1 * 6 < len2 || len2 * 6 < len1)
            return -1;

        int count = 0;
        int sum1 = 0, sum2 = 0;
        for (int val : nums1) {
            sum1 += val;
        }
        for (int val : nums2) {
            sum2 += val;
        }
        if (sum1 > sum2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            len1 = nums1.length;
            len2 = nums2.length;
            sum1 ^= sum2;
            sum2 ^= sum1;
            sum1 ^= sum2;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);


        int index1 = 0, index2 = len2 - 1;
        while (sum1 != sum2) {
            int remain = sum2 - sum1;
            if (index1 == len1) {
                // 此时小的数组以及移到了最右侧，此时只能移动num2
                remain = Math.min(remain, nums2[index2--] - 1);
                sum2 -= remain;
            } else if (index2 == -1) {
                // 此时大的数组以及移到了最左侧，此时只能移动num1
                remain = Math.min(remain, 6 - nums1[index1++]);
                sum1 += remain;
            } else {
                // 此时比较当前两个数组指针的位置，谁的差距大用谁的
                if (6 - nums1[index1] > nums2[index2] - 1) {
                    remain = Math.min(remain, 6 - nums1[index1++]);
                    sum1 += remain;
                } else {
                    remain = Math.min(remain, nums2[index2--] - 1);
                    sum2 -= remain;
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Demo1775 demo1775 = new Demo1775();
        int[] num1 = {1,2,3,4,5,6}, num2 = {1,1,2,2,2,2};
        System.out.println(demo1775.minOperations(num1, num2));
    }
}
