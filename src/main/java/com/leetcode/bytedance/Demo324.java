package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/6/28 11:08 下午
 * @Version 1.0
 */
public class Demo324 {

    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int len = nums.length;
        int half = (arr.length + 1) / 2;
        for (int i = 0, j = half - 1, k = len - 1; i < len; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < len)
                nums[i + 1] = arr[k];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3,3};
        Demo324 demo324 = new Demo324();
        demo324.wiggleSort(nums);
        for (int num : nums) {
            System.out.print(num);
        }
    }
}
