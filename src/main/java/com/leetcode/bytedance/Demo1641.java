package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/3/29 7:15 下午
 * @Version 1.0
 */
public class Demo1641 {

    public static int countVowelStrings(int n) {
        int[] memo = {1, 1, 1, 1, 1};
        int sum = 5;
        for (int i = 1; i < n; i++) {
            int[] array = new int[5];
            array[0] = sum;
            for (int j = 1; j < memo.length; j++) {
                array[j] = array[j - 1] - memo[j - 1];
                sum += array[j];
            }
            memo = array;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countVowelStrings(3));
    }
}
