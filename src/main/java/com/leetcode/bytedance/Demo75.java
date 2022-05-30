package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/25 10:13 下午
 * @Version 1.0
 */
public class Demo75 {

    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * 使用快排解决
     * @param nums
     * @param begin
     * @param end
     */
    private void quickSort(int[] nums, int begin, int end) {
        if (begin < end) {
            int key = nums[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                while (j > i && nums[j] > key)
                    j--;

                if (j > i) {
                    nums[i] = nums[j];
                    i++;
                }

                while (j > i && nums[i] < key)
                    i++;

                if (j > i) {
                    nums[j] = nums[i];
                    j--;
                }
            }

            nums[i] = key;
            quickSort(nums, begin, i - 1);
            quickSort(nums, i + 1, end);
        }
    }
}
