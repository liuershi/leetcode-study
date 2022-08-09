package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/28 11:59 下午
 * @Version 1.0
 */
public class Demo260 {

    public int[] singleNumber(int[] nums) {
        // 先求出 a ^ b
        int xorAb = 0;
        for (int num : nums) {
            xorAb ^= num;
        }

        // 因为a和b不一样，所以xorAb一定不为0
        // 取得xorAb最右边的位1
        int rightOne = xorAb & (~xorAb + 1);

        // 再次遍历
        int xorAOrb = 0;
        for (int num : nums) {
            if ((rightOne & num) == 0) xorAOrb ^= num;
        }

        // 此时xorAOrb值中包含a或b
        int a = xorAb ^ xorAOrb;
        int b = xorAb ^ a;
        return new int[]{a, b};
    }
}
