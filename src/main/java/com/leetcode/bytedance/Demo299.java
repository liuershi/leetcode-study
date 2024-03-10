package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2024/3/10 8:40 下午
 * @Version 1.0
 */
public class Demo299 {

    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int len = secret.length();
        int[] secretMemo = new int[10];
        int[] guessMemo = new int[10];
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                secretMemo[secret.charAt(i) - '0']++;
                guessMemo[guess.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < len; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                continue;
            }

            if (secretMemo[s - '0'] > 0 && guessMemo[s - '0'] > 0) {
                secretMemo[s - '0']--;
                guessMemo[s - '0']--;
                cows++;
            }
            if (secretMemo[g - '0'] > 0 && guessMemo[g - '0'] > 0) {
                secretMemo[g - '0']--;
                guessMemo[g - '0']--;
                cows++;
            }
        }

        return bulls + "A" + cows + "B";
    }
}
