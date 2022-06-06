package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/6 11:45 下午
 * @Version 1.0
 */
public class Demo125 {

    public boolean isPalindrome(String s) {
        int len;
        if (s == null || (len = s.length()) == 1)
            return true;

        char[] chars = s.toCharArray();
        int left = 0, right = len - 1;

        while (left < right) {
            char lc = chars[left];
            char rc = chars[right];
            if (!Character.isLetter(lc) && !Character.isDigit(lc)) {
                left++;
                continue;
            }
            if (!Character.isLetter(rc) && !Character.isDigit(rc)) {
                right--;
                continue;
            }
            if (lc >= 65 && lc <= 90) lc += 32;
            if (rc >= 65 && rc <= 90) rc += 32;
            if (lc != rc && Math.abs(lc - rc) != 32) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "0P";
        Demo125 demo125 = new Demo125();
        System.out.println(demo125.isPalindrome(s));
    }
}
