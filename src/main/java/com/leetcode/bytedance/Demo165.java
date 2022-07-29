package com.leetcode.bytedance;

/**
 * @author zhangwei151
 * @date 2022/7/28 16:21
 */
public class Demo165 {

    public int compareVersion(String version1, String version2) {
        String[] versionsOne = version1.split("\\.");
        String[] versionsTwo = version2.split("\\.");
        int min = Math.min(versionsOne.length, versionsTwo.length);
        for (int i = 0; i < min; i++) {
            int val1 =Integer.parseInt(versionsOne[i]);
            int val2 =Integer.parseInt(versionsTwo[i]);
            if (val1 > val2) return 1;
            else if (val1 < val2) return -1;
        }
        int max = Math.max(versionsOne.length, versionsTwo.length);
        if (min != max) {

            for (int i = min; i < max; i++) {
                if (versionsOne.length > min && Integer.parseInt(versionsOne[i]) > 0) return 1;
                if (versionsTwo.length > min && Integer.parseInt(versionsTwo[i]) > 0) return -1;
            }
        }
        return 0;
    }
}
