package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/12/13 10:43 下午
 * @Version 1.0
 */
public class Demo1832 {

    public boolean checkIfPangram(String sentence) {
//        return method1(sentence);
        // 思路二：使用二进制位判断，最后二进制位数为26则符合
        int bitCounts = 0;
        for (char c : sentence.toCharArray()) {
            bitCounts |= 1 << (c - 'a');
            if (bitCounts == 0x3ffffff) return true;
        }
        return false;
    }

    /**
     * 思路一：直接模拟
     * @param sentence
     * @return
     */
    private boolean method1(String sentence) {
        int n = sentence.length();
        if (n < 26) {
            return false;
        }

        int[] memo = new int[26];
        int uniqueLetterNumber = 0;
        for (int i = 0; i < n; i++) {
            if (memo[sentence.charAt(i) - 'a']++ == 0 && ++uniqueLetterNumber == 26) {
                return true;
            }
            if (uniqueLetterNumber + n - i - 1 < 26) {
                return false;
            }
        }
        return false;
    }
}
