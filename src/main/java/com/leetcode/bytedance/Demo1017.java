package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/4/6 6:52 下午
 * @Version 1.0
 */
public class Demo1017 {

    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int val = Math.abs(n % -2);
            sb.append(val);
            n = (n - val) / -2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Demo1017 demo1017 = new Demo1017();
        System.out.println(demo1017.baseNeg2(5));

        System.out.println(Integer.toBinaryString(-127));
    }
}
