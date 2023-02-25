package com.leetcode.weekly.week333;

/**
 * @Author milindeyu
 * @Date 2023/2/19 10:42 上午
 * @Version 1.0
 */
public class Demo6265 {

    public static int minOperations(int n) {
        int count = 0;
        while (n != 0) {
            String content = Integer.toBinaryString(n);
            boolean add = false;
            for (int i = content.length() - 1; i >= 0; i--) {
                if (content.charAt(i) == '0') {
                    continue;
                }
                if (i - 1 >= 0 && content.charAt(i) == content.charAt(i - 1) && content.charAt(i) == '1') {
                    add = true;
                }
                break;
            }
            int rightBit = (~n + 1) & n;
            if (!add) {
                rightBit = -rightBit;
            }
            n += rightBit;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(39));
        System.out.println(Integer.toBinaryString(40));
        System.out.println(Integer.toBinaryString(32));

        System.out.println("===");
        System.out.println(Integer.toBinaryString(54));
        System.out.println(Integer.toBinaryString(56));
        System.out.println(Integer.toBinaryString(64));

        System.out.println("===");
        System.out.println(Integer.toBinaryString(25));
        System.out.println(minOperations(25));
    }
}
