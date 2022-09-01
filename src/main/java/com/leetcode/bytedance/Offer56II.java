package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/9/1 11:50 下午
 * @Version 1.0
 */
public class Offer56II {

    public int singleNumber(int[] nums) {
//        return method1(nums);

        // 思路二：对于每个数，如果出现了三次，那么每个数的二进制位也一定出现三次，那么
        // 对于所有出现三次的数的二进制位的和也一定能被三整除，那个出现一次的数的每一位
        // 一定都余1
        // 时间复杂度：O(n) 空间复杂度：O(1)
        // int的位位32，记录所有数每一位的个数
        int[] bitSum = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitSum[i] += num & 1;
                num >>= 1;
            }
        }

        int res = 0;
        // 遍历bitSum，判断每位数否能被3整除，可以的话改位上不存在那个出现一次数的位
        for (int i = 31; i >= 0; i++) {
            res <<= 1;
            if (bitSum[i] % 3  != 0) {
                res |= 1;
            }
        }
        return res;
    }

    private Integer method1(int[] nums) {
        // 思路一：Map判断
        // 时间复杂度：O(n)  空间复杂度：O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == 3) map.remove(num);
        }
        return map.entrySet().iterator().next().getKey();
    }
}
