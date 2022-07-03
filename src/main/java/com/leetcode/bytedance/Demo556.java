package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/7/3 11:23 下午
 * @Version 1.0
 */
public class Demo556 {

    public int nextGreaterElement(int n) {
        char[] chars = Integer.toString(n).toCharArray();
        int i = chars.length - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }
        // 说明此时n中每个数字是递减的
        if (i < 0) return -1;

        int j = chars.length - 1;
        while (j >= i && chars[i] >= chars[j]) j--;

        swap(chars, i, j);
        Arrays.sort(chars, i + 1, chars.length);
        long l = Long.parseLong(new String(chars));
        return l > Integer.MAX_VALUE ? -1 : (int) l;
    }

    private void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    public static void main(String[] args) {
        Demo556 demo556 = new Demo556();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(demo556.nextGreaterElement(2147483486));
    }
}
