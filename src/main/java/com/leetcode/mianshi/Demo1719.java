package com.leetcode.mianshi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author zhangwei151
 * @date 2022/9/26 1:06
 */
public class Demo1719 {

    public int[] missingTwo(int[] nums) {
//        return method(nums);
        // 思路二：在当前数组后面加上1~n，按位异或所有数，则出现两次的数会抵消掉
        int xor = 0;
        for (int i = 1; i <= nums.length; i++) {
            xor ^= i ^ nums[i - 1];
        }
        xor ^= nums.length + 1;
        xor ^= nums.length + 2; // 此时xor等于缺失两个数的异或
        // 获取最右边的一位
        int rightOne = xor & (~xor + 1);
        int xor1 = 0;
        for (int i = 1; i <= nums.length + 2; i++) {
            if ((i & rightOne) == 0) xor1 ^= i;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & rightOne) == 0) xor1 ^= nums[i];
        }
        // 此时xor1就是某一位缺失的数
        int a = xor ^ xor1;
        int b = xor ^ a;
        return new int[]{a, b};
    }

    /**
     * 时间复杂度：排序O(nlogn) + 遍历O(n)
     * 空间复杂度：O(1)
     */
    private int[] method(int[] nums) {
        // 思路一：直接遍历
        Arrays.sort(nums);
        int start = 0;
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - start;
            if (diff == 1) ;
            else if (diff == 2) {
                if (res[0] == 0) res[0] = start + 1;
                else res[1] = start + 1;
            } else {
                res[0] = start + 1;
                res[1] = start + 2;
            }
            if (res[1] != 0) break;
            start = nums[i];
        }
        if (res[0] == 0) res[0] = nums.length + 1;
        if (res[1] == 0) res[1] = nums.length + 2;
        return res;
    }

    public static void main(String[] args) {
        Demo1719 demo1719 = new Demo1719();
        int[] nums = {1, 2, 3, 4, 6, 7, 9, 10};
        System.out.println(Arrays.toString(demo1719.missingTwo(nums)));
    }
}
