package com.leetcode.weekly.twoweek.week86;

import java.math.BigInteger;

/**
 * @Author milindeyu
 * @Date 2022/9/3 10:55 下午
 * @Version 1.0
 */
public class Demo6172 {

    public boolean isStrictlyPalindromic(int n) {
        for (int i = n - 2; i >= 2; i--) {
            String palindrome = new java.math.BigInteger(String.valueOf(n), 10).toString(i);
            if (!isPalindrome(palindrome)) return false;
        }
        return true;
    }

    public boolean isPalindrome(String palindrome) {
        int left = 0, right = palindrome.length() - 1;
        while (left < right) {
            if (palindrome.charAt(left) != palindrome.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Demo6172 demo6172 = new Demo6172();
        System.out.println(demo6172.isStrictlyPalindromic(171));
    }
}
