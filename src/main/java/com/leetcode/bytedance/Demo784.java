package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/10/30 12:42 上午
 * @Version 1.0
 */
public class Demo784 {

    List<String> rsp = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        // 思路：dfs
        StringBuilder sb = new StringBuilder();
        dfs(sb, s, 0);
        return rsp;
    }

    private void dfs(StringBuilder sb, String content, int idx) {
        if (sb.length() == content.length()) {
            rsp.add(sb.toString());
            return;
        }

        dfs(sb.append(content.charAt(idx)), content, idx + 1);
        // 如果为字符变换大小写
        if (Character.isLetter(content.charAt(idx))) {
            // 将大写变小写，小写变大写
            sb.setCharAt(idx, (char) (sb.charAt(idx) ^ 32));
            dfs(sb, content, idx + 1);
            sb.setCharAt(idx, (char) (sb.charAt(idx) ^ 32));
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println((char) ('a' ^ 32));
        System.out.println((char) ('A' ^ 32));
    }
}
