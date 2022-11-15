package com.leetcode.weekly.week319;

/**
 * @Author milindeyu
 * @Date 2022/11/13 10:40 上午
 * @Version 1.0
 */
public class Demo6234 {

    public int subarrayLCM(int[] nums, int k) {
        int rsp = 0;

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int lcm = nums[i];
            for (int j = i; j < n; j++) {
                if ( k % nums[i] != 0 || k % nums[j] != 0)
                    break;
                lcm = lcm(lcm, nums[j]);
                if (lcm == k) rsp++;
            }
        }

        return rsp;
    }

    /**
     * 最小公倍数
     * @param x
     * @param y
     * @return
     */
    public int lcm(int x, int y) {
        for (int i = 1; i < x * y; i++) {
            if (i % x == 0 && i % y == 0)
                return i;
        }
        return x * y;
    }

    public static void main(String[] args) {
        Demo6234 demo6234 = new Demo6234();
        System.out.println(demo6234.subarrayLCM(new int[]{3, 6, 2, 7, 1}, 6));
    }
}
