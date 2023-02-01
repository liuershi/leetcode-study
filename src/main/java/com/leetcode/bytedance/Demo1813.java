package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/1/16 7:00 下午
 * @Version 1.0
 */
public class Demo1813 {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] strs1 = sentence1.split(" ");
        String[] strs2 = sentence2.split(" ");
        int l1 = 0, r1 = strs1.length - 1,
                l2 = 0, r2 = strs2.length - 1;
        boolean equals = false;
        while (l1 <= r1 && l2 <= r2) {
            if (strs1[l1].equals(strs2[l2])) {
                l1++;
                l2++;
                equals = true;
            } else {
                if (strs1[r1].equals(strs2[r2])) {
                    equals = true;
                    r1--;
                    r2--;
                } else {
                    break;
                }
            }
        }

        return equals && (l1 > r1 || l2 > r2);
    }
}
