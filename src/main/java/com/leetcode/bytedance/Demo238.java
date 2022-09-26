package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/9/26 10:51 下午
 * @Version 1.0
 */
public class Demo238 {

    public int[] productExceptSelf(int[] nums) {
        // 思路：先求所有数的乘积，然后遍历每个数除以对于数
        // 注意点：遍历数时判断对于值是否为0，对于为0的数要排除作为乘积同时记录对于的下标，在后续处理时特殊对待
        // 时间和空间复杂度都为：O(n)
        int len = nums.length;
        int[] res = new int[len];
        Set<Integer> zeros = new HashSet<>();
        int multiply = 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) zeros.add(i);
            else multiply *= nums[i];
        }
        if (zeros.size() > 1) {
            Arrays.fill(res, 0);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (zeros.isEmpty()) {
                    res[i] = multiply / nums[i];
                } else if (zeros.contains(i)) res[i] = multiply;
                else res[i] = 0;
            }
        }
        return res;
    }
}
