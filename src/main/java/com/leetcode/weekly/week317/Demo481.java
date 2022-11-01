package com.leetcode.weekly.week317;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author milindeyu
 * @Date 2022/10/31 10:46 下午
 * @Version 1.0
 */
public class Demo481 {

    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        int rsp = 1;
        int curVal = 1, index = 1;
        while (sb.length() < n) {
            curVal ^= 3;
            int len = sb.length() == index ? curVal : sb.charAt(index) - '0';
            for (int i = 0; i < len; i++) {
                sb.append(curVal);
            }
            if (curVal == 1) rsp += len;
            index++;
        }
        if (sb.length() > n && sb.charAt(sb.length() - 1) == '1') rsp--;
        return rsp;
    }

    public static void main(String[] args) {
        Demo481 demo481 = new Demo481();
        System.out.println(demo481.magicalString(48));
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = random.nextInt(1000);
        }

        for (int num : nums) {
            System.out.println(num);
        }
        System.out.println("======");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(demo481.magicalString(nums[i]));
        }
    }
}
