package com.leetcode.zcy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/4/19 7:45 下午
 * @Version 1.0
 */
public class Demo13 {

    private List<String> result = new ArrayList<>();

    /**
     * 得到指定字符串的全排列
     * @param s
     * @return
     */
    public List<String> permute(String s) {
        if (s == null || s.length() == 0) return Collections.singletonList(s);
        char[] chars = s.toCharArray();
        process(chars, 0);
        return result;
    }

    private void process(char[] chars, int i) {
        if (i == chars.length) {
            result.add(String.valueOf(chars));
            return;
        }
        boolean[] booleans = new boolean[26];
        for (int j = i; j < chars.length; j++) {
            if (!booleans[chars[j] - 'a']) {
                booleans[chars[j] - 'a'] = true;
                swap(chars, i, j);
                process(chars, i + 1);
                swap(chars, i, j);
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        Demo13 demo13 = new Demo13();
        System.out.println(demo13.permute("abc"));
    }
}
