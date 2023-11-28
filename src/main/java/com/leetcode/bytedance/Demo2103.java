package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/11/2 11:32 下午
 * @Version 1.0
 */
public class Demo2103 {

    public int countPoints(String rings) {
        char[] chars = rings.toCharArray();
        int n = chars.length >> 1;
        int[][] memo = new int[10][4];
        int ans = 0;
        for (int i = 0; i < chars.length; i += 2) {
            int idx = getIdxFromColor(chars[i]);
            int num = chars[i + 1] - '0';
            if (memo[num][3] != 3 && memo[num][idx] == 0) {
                memo[num][idx]++;
                if (++memo[num][3] == 3) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private int getIdxFromColor(char color) {
        if (color == 'R') {
            return 0;
        } else if (color == 'G') {
            return 1;
        } else {
            return 2;
        }
    }
}
