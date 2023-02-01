package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/1/19 7:40 下午
 * @Version 1.0
 */
public class Demo2299 {

    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8)
            return false;
        boolean hasLower = false, hasUpper = false,
                hasDigit = false, hasSpecial = false;
        String special = "!@#$%^&*()-+";
        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i]))
                hasDigit = true;
            else if (Character.isLowerCase(chars[i]))
                hasLower = true;
            else if (Character.isUpperCase(chars[i]))
                hasUpper = true;
            else if (special.contains(String.valueOf(chars[i])))
                hasSpecial = true;
            if (i > 0 && chars[i] == chars[i - 1])
                return false;
        }
        return hasDigit && hasUpper && hasLower && hasSpecial;
    }
}
