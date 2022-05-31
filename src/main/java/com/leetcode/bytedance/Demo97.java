package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/31 12:48 上午
 * @Version 1.0
 */
public class Demo97 {

    /**
     * @link https://leetcode.cn/problems/interleaving-string/solution/dong-tai-gui-hua-zhu-xing-jie-shi-python3-by-zhu-3/
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l1 + l2 != l3)
            return false;

        boolean[][] matrix = new boolean[l1 + 1][l2 + 1];
        matrix[0][0] = true;
        for (int i = 1; i <= l1; i++)
            matrix[i][0] = matrix[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);

        for (int i = 1; i <= l2; i++)
            matrix[0][i] = matrix[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                matrix[i][j] = (matrix[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))
                        || (matrix[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }
        return matrix[l1][l2];
    }

}
