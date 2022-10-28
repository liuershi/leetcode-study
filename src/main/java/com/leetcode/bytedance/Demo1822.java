package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/10/27 9:51 下午
 * @Version 1.0
 */
public class Demo1822 {

    public int arraySign(int[] nums) {
            int multiply = 1;
            for (int val : nums) {
                if (val == 0) return 0;
                multiply *= val;
                multiply = multiply > 0 ? 1 : -1;
            }
            return multiply;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-1));
    }
}
