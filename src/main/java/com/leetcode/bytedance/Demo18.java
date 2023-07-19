package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2023/7/15 5:07 下午
 * @Version 1.0
 */
public class Demo18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (nums[i] + nums[j] > target && nums[j + 1] >= 0) {
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1, right = len - 1;
                while (left < right) {
                    int val = nums[i] + nums[j] + nums[left] + nums[right];
                    if (val == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        do {
                            left++;
                        } while (left < right && nums[left - 1] == nums[left]);
                        do {
                            right--;
                        } while (left < right && nums[right] == nums[right + 1]);
                    } else if (val < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
