package com.leetcode.weekly.week326;

/**
 * @Author milindeyu
 * @Date 2023/1/1 11:01 上午
 * @Version 1.0
 */
public class Demo6280 {

    public int[] closestPrimes(int left, int right) {
        int nums1 = primeNum(left, right - 2), nums2 = primeNum(nums1 + 1, right);
        if (nums1 == -1 || nums2 == -1)
            return new int[]{-1, -1};
        int val1 = nums1, val2 = nums2;
        while (val2 != -1) {
            val1 = val2;
            val2 = primeNum(val2 + 2, right);
            if (val2 != -1 && val2 - val1 < nums2 - nums1) {
                nums1 = val1;
                nums2 = val2;
            }
        }
        return new int[]{nums1, nums2};
    }

    public int primeNum(int start, int end) {

        boolean sign;
        for (int i = start; i <= end; i++) {
            if (i == 1) continue;
            if (i % 2 == 0 && i != 2) continue; // 偶数和1排除

            sign = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    sign = false;
                    break;
                }
            }

            if (sign)
                return i;
        }

        return -1;
    }

    public static void getPrime(int left, int right) {
        int n = right - left;
        boolean []st = new boolean[n + 1];  // 状态数组，标识是否被筛掉
        int []primes = new int[n + 1];  // 存放质数
        int cnt = 0;  //质数的个数

        for(int i = left; i <= right; i++) {  // 线性筛
            if(!st[i]) primes[cnt++] = i;
            for(int j = 0; primes[j] <= n / i; j++) {  //只用最小质因子筛，（筛一次）
                st[primes[j] * i] = true;
                if(i % primes[j] == 0) break;
            }
        }
    }


    public static void main(String[] args) {
        Demo6280 demo6280 = new Demo6280();
        demo6280.closestPrimes(69346, 69379);
    }
}
