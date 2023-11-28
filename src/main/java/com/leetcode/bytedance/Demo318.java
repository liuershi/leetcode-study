package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/11/6 9:44 下午
 * @Version 1.0
 */
public class Demo318 {

    public int maxProduct(String[] words) {
        int[] binaryNums = new int[words.length];
        transfer(binaryNums, words);
        int max = 0;
        for (int i = 0; i < binaryNums.length - 1; i++) {
            for (int j = i + 1; j < binaryNums.length; j++) {
                if ((binaryNums[i] & binaryNums[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    private void transfer(int[] binaryNums, String[] words) {
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            int val = 0;
            for (int j = 0; j < chars.length; j++) {
                val |= 1 << (chars[j] - 'a');
            }
            binaryNums[i] = val;
        }
    }
}
