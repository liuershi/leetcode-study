package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/10/18 10:12 下午
 * @Version 1.0
 */
public class Demo902 {

    String[] digits;
    char[] chars;
    int[] dp;
    public int atMostNGivenDigitSet(String[] digits, int n) {
        // 思路：数位dp
        this.digits = digits;
        chars = Integer.toString(n).toCharArray();
        dp = new int[chars.length];
        // 初始化为默认值
        Arrays.fill(dp, -1);;
        return process(0, true, false);
    }

    /**
     * 表示构造从左往右第 index 位及其之后数位的合法方案数
     * @param index 当前处理下标
     * @param isLimit 表示当前是否受到了 n 的约束
     * @param isNum 表示 index 前面的数位是否填了数字
     */
    private int process(int index, boolean isLimit, boolean isNum) {
        if (index == chars.length) return isNum ? 1 : 0; // 当处理到n的长度时，如果前面插入了数字则当前数字有效，否则无效
        // 当没受到限制且前面插入了数字，返回缓存中的值，避免重复计算
        if (!isLimit && isNum && dp[index] >= 0) return dp[index];

        int res = 0;
        if (!isNum) {
            // 如果此时 index 前面未填数字，那么当前位置也可以不填数字
            // isLimit为false：因为此时没有填任何数字，那么最终的数肯定比n要短，那么不会受到n的限制
            // isNum为false：因为之前没有填数字，现在没有填数字仍然为false
            res = process(index + 1, false, false);
        }

        // 当受到n的限制时，那么 index 位置的值也受到限制，此时值至多为s[index]，否则不受限制至多为'9'
        char up = isLimit ? chars[index] : '9';
        for (String digit : digits) {
            // 由于digits是递增的，所以当 i 的元素大于上界up时，后面的数都不用计算了，肯定也是大于up的，直接跳出
            if (digit.charAt(0) > up) break;
            // isLimit：当为true时，且当前元素为上界up的值时继续限制
            // isNum：由于当前以及插入数字，所以此时为true
            res += process(index + 1, isLimit && digit.charAt(0) == up, true);
        }
        // 当未收到任何限制且已插入数据时记录计算结果
        if (!isLimit && isNum) dp[index] = res;

        return res;
    }
}
