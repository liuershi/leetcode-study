package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/10/20 10:28 下午
 * @Version 1.0
 */
public class Demo779 {

    public int kthGrammar(int n, int k) {
        // 思路：每一层的前半部分和上一层一样，后面一半是上一层元素的反转
        // 这里的反转是指 0 ==> 1  1 ==> 0 的意思
        // 如果k为当前层的前半部分，那么取上一层相同位置元素即可，否则在后半部分，
        // 则需要取上一层相同位置元素的反转
        if (n == 1) return 0;
        // 计算当前层集合长度的一半
        int halfLen = (int) Math.pow(2, n - 2);
        if (k <= halfLen)
            return kthGrammar(n - 1, k);
        else
            return kthGrammar(n - 1, k >> 1) ^ 1;
    }
}
