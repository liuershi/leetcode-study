package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/2/13 7:18 下午
 * @Version 1.0
 */
public class Demo1234 {

    public int balancedString(String s) {
        int[] memo = new int[26];
        int len = s.length();

        for (int i = 0; i < len; i++) {
            memo[s.charAt(i) - 'A']++;
        }

        int n = len / 4;
        if (check(memo, n)) {
            return 0;
        }

        int ans = len;
        for (int l = 0, r = 0; l < len; l++) {
            while (r < len && !check(memo, n)) {
                memo[s.charAt(r++) - 'A']--;
            }
            if (!check(memo, n)) {
                break;
            }

            ans = Math.min(ans, r - l);
            // 此时l位置会左移，所以此时要加上l位置的此时
            memo[s.charAt(l) - 'A']++;
        }
        return ans;
    }


    private boolean check(int[] memo, int n) {
        return !(memo['Q' - 'A'] > n || memo['W' - 'A'] > n || memo['E' - 'A'] > n || memo['R' - 'A'] > n);
    }


    public static void main(String[] args) {
        Demo1234 demo1234 = new Demo1234();
        System.out.println(demo1234.balancedString("EQWEQRWREWQEERWQEQEWRQWREQWEWRWEQEWWQEQRWREEWQWQWQWWWWERRRRR"));
    }
}
