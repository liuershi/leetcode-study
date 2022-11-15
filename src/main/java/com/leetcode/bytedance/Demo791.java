package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author milindeyu
 * @Date 2022/11/13 12:29 上午
 * @Version 1.0
 */
public class Demo791 {

    public String customSortString(String order, String s) {
//        return method1(order, s);
        int[] memo = new int[26];
        StringBuilder sb = new StringBuilder();
        // 记录目标字符串每个字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            memo[s.charAt(i) - 'a']++;
        }
        // 遍历order，查询s的内容，那么此时查出来的s顺序和order一致
        for (int i = 0; i < order.length(); i++) {
            int count = memo[order.charAt(i) - 'a'];
            if (count > 0) {
                while (count-- > 0)
                    sb.append(order.charAt(i));
                memo[order.charAt(i) - 'a'] = 0;
            }
        }
        // 遍历字典查出不在order的字符
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i]; j++) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }

    /**
     * 普通的记录位置在对目标字符串排序
     *
     * 时间：3ms
     *
     * @param order
     * @param s
     * @return
     */
    private String method1(String order, String s) {
        int[] memo = new int[26];
        Arrays.fill(memo, -1);
        for (int i = 0; i < order.length(); i++) {
            memo[order.charAt(i) - 'a'] = i;
        }
        int idx = order.length();
        for (int i = 0; i < 26; i++) {
            if (memo[i] == -1) {
                memo[i] = idx++;
            }
        }
        Character[] content = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            content[i] = s.charAt(i);
        }
        Arrays.sort(content, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return memo[o1 - 'a'] - memo[o2 - 'a'];
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Character c : content) {
            sb.append(c);
        }
        return sb.toString();
    }
}
