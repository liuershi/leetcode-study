package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangwei151
 * @date 2022/8/21 23:55
 */
public class Offer38 {

    List<String> res = new ArrayList<>();
    boolean[] visitor;
    char[] chars;
    public String[] permutation(String s) {
        // 思路：回溯模拟整个过程
        // 注意：由于结果中不能包含重复结果，最好是在模拟过程中剪枝去重，减少重复计算

        chars = s.toCharArray();
        Arrays.sort(chars); // 排序市相同的字符在一起
        visitor = new boolean[chars.length]; // 记录访问过的下标
        StringBuilder sb = new StringBuilder();
        backtrack(sb);
        return res.toArray(new String[]{});
    }

    private void backtrack(StringBuilder sb) {
        if (sb.length() == chars.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visitor[i]) continue;
            if (i > 0 && visitor[i - 1] && chars[i] == chars[i - 1]) continue; // 剪枝，相邻相同字符直接排除
            visitor[i] = true;
            sb.append(chars[i]);
            backtrack(sb);
            sb.deleteCharAt(sb.length() - 1);
            visitor[i] = false;
        }
    }
}
