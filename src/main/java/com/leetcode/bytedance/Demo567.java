package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/5 10:43 下午
 * @Version 1.0
 */
public class Demo567 {

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
        // 缓存s1每个字符的计数
        int[] nums = new int[26];
        for (char c : s1.toCharArray()) {
            nums[c - 'a']++;
        }

        for (int i = 0; i < len2; i++) {
            nums[s2.charAt(i) - 'a']--;
            if (i >= len1) {
                nums[s2.charAt(i - len1) - 'a']++;
            }
            // 当此时遍历到的节点长度至少等于s1时判断nums是否都为0
            if (i >= len1 - 1 && isEmpty(nums)) return true;
        }
        return false;
    }

    private boolean isEmpty(int[] nums) {
        for (int num : nums) {
            if (num != 0) return false;
        }
        return true;
    }
}
