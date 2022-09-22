package com.leetcode.weekly.miohayo;

/**
 * @Author milindeyu
 * @Date 2022/9/4 11:13 上午
 * @Version 1.0
 */
public class Demo6169 {

    public int longestNiceSubarray(int[] nums) {
        int res = 1;
        int left = 0, right = 1;
        while (left < right && right < nums.length) {
            if (isProcess(left, right, nums)) {
                res = Math.max(res, right - left + 1);
                right++;
                continue;
            }
            right++;
            left++;
            while (right < nums.length && left < right - 1 && !isProcess(left, right, nums)) {
                left++;
            }
        }
        return res;
    }

    private boolean isProcess(int left, int right, int[] nums) {
        for (int i = left; i < right ; i++) {
            for (int j = i + 1; j <= right; j++) {
                if ((nums[i] & nums[j]) != 0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Demo6169 demo6169 = new Demo6169();
        int[] nums = {744437702,379056602,145555074,392756761,560864007,934981918,113312475,1090,16384,33,217313281,117883195,978927664};
        System.out.println(demo6169.longestNiceSubarray(nums));
    }
}
