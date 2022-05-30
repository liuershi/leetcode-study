package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/3/29 9:28 下午
 * @Version 1.0
 */
public class Demo2024 {

    /**
     * 可理解为，从字符串answerKey中，查询包含字符串T或F不超过k个的最长子串（滑动窗口）
     * @param answerKey
     * @param k
     * @return
     */
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(getCnt('T', k, answerKey), getCnt('F', k, answerKey));
    }

    int getCnt(char c, int k, String s) {
        int max = 0;
        for (int l = 0, r = 0, cnt = 0; r < s.length(); r++) {
            // 移到右边界
            if (s.charAt(r) == c) ++cnt;
            while (cnt > k) {
                if (s.charAt(l++) == c) --cnt;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Demo2024 demo2024 = new Demo2024();
        System.out.println(demo2024.maxConsecutiveAnswers("TFFT", 1));
    }
}
