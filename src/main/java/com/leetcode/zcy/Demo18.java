package com.leetcode.zcy;

/**
 *
 * 回文字串解决
 *
 * @Author milindeyu
 * @Date 2022/4/23 10:32 下午
 * @Version 1.0
 */
public class Demo18 {

    /**
     * 方式一：暴力求解
     *
     * 使用每个字符串作为中轴，向两边扩张判断，注意该种方式会导致偶数回文串无法被找到
     * 故需要在每个字符串中间加一个特殊字符辅助。
     *
     * abba ==> a#b#b#a
     *
     * @param s
     * @return
     */
    public String palindromeStr(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String newStr = String.join("#", s.split(""));
        newStr = "#" + newStr + "#";

        char[] chars = newStr.toCharArray();
        int idx = 0, max = 1;
        for (int i = 1; i < chars.length; i++) {
            int start = i - 1, end = i + 1;
            while (start >= 0 && end < chars.length) {
                if (chars[start] != chars[end]) {
                    break;
                }
                if (end - start > max) {
                    max = end - start;
                    idx = start;
                }
                start--;
                end++;
            }
        }
        return newStr.substring(idx, idx + max).replace("#", "");
    }


    public static void main(String[] args) {
        Demo18 demo18 = new Demo18();
        System.out.println(demo18.palindromeStr("cbbd"));
    }
}
