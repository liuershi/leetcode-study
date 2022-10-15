package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/10/15 9:50 下午
 * @Version 1.0
 */
public class Demo738 {

    public int monotoneIncreasingDigits(int n) {
        // 思路：向前遍历，如果前面字符大于后面字符，则前面字符
        // 剪1，后面字符变为9
        char[] content = String.valueOf(n).toCharArray();
        for (int i = content.length - 2; i >=0; i--) {
            if (content[i] > content[i + 1]) {
                content[i]--;
                for (int j = i + 1; j < content.length; j++) {
                    content[j] = '9';
                }
            }
        }
        return Integer.parseInt(new String(content));
    }
}
