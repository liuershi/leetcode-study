package com.leetcode.weekly.week326;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2023/1/1 10:39 上午
 * @Version 1.0
 */
public class Demo6279 {

    public int distinctPrimeFactors(int[] nums) {
        Map<Integer, Set<Integer>> map = new HashMap<>(1000);
        Set<Integer> allSet = new HashSet<>();
        for (int num : nums) {
            Set<Integer> set = map.getOrDefault(num, resolvePrime(num));
            map.put(num, set);
            allSet.addAll(set);
        }
        return allSet.size();
    }

    public Set<Integer> resolvePrime(int num) {

        Set<Integer> set = new HashSet<>();

        // 定义最小素数
        int i = 2;

        // 进行辗转相除法
        while (i <= num) {

            // 若num 能整除 i ，则i 是num 的一个因数
            if (num % i == 0) {

                // 将i 保存进sb 且 后面接上 *
                set.add(i);

                // 同时将 num除以i 的值赋给 num
                num = num / i;

                // 将i重新置为2
                i = 2;
            } else {

                // 若无法整除，则i 自增
                i++;
            }
        }
        return set;
    }

}
