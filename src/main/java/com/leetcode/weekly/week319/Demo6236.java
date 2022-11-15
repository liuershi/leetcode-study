package com.leetcode.weekly.week319;

/**
 * @Author milindeyu
 * @Date 2022/11/13 11:42 上午
 * @Version 1.0
 */
public class Demo6236 {

    public int maxPalindromes(String s, int k) {
        int l = -1;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i <= l) continue;
            int start = i, end = i;
            while (end - start + 1 < k && end < s.length() - 1  && s.charAt(end + 1) == s.charAt(end)) ++end;
            while (end - start + 1 < k && start > l + 1 && end < s.length() - 1 && s.charAt(start - 1) == s.charAt(end + 1)) {
                --start;
                ++end;
            }
            if (end - start + 1 >= k) {
                ++ans;
                l = end;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Demo6236 demo6236 = new Demo6236();
        System.out.println(demo6236.maxPalindromes("kwnwkekokedadq", 5));
    }
}
