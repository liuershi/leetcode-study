package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/3/19 9:47 下午
 * @Version 1.0
 */
public class Demo30 {

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int middle = (high + low) / 2;
            int num = nums[middle];
            if (num == target) {
                return middle;
            } else if (num < nums[high]) {
                if (target > num && target <= nums[high]) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            } else {
                if (nums[low] <= target && target <= nums[middle]) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Demo30 demo30 = new Demo30();
        System.out.println(demo30.search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
