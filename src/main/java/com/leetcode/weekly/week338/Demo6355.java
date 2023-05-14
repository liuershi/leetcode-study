package com.leetcode.weekly.week338;

/**
 * @Author milindeyu
 * @Date 2023/3/26 11:53 上午
 * @Version 1.0
 */
public class Demo6355 {

    public boolean primeSubOperation(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int prime = countPrime(nums[i]);
            if (prime != nums[i]) {
                nums[i] -= prime;
            }
            if (i > 0 && nums[i] <= nums[i - 1]) {
                nums[i] += prime;
            }
            if (i > 0 && nums[i] <= nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private int countPrime(int num) {
        if (num <= 1) {
            return num;
        }
        // ///大于这个数的最小素数
        int answer = num - 1;
        // 上面+1是从这个数的下一个数去判断，而不判断这个数本身是不是一个素数
        while (isPrime(answer)) {
            answer--;
        }
        return answer;

    }

    private boolean isPrime(int num) {
        // //计算到这个数的平方根，减少计算步骤
        for (int i = 2; i <= Math.sqrt(num); i++) {
            // /判断一个数整除变量i的余数是否为0，为零说明能整除，则不是素数
            if (num % ((int) i) == 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Demo6355 demo6355 = new Demo6355();
        System.out.println(demo6355.primeSubOperation(new int[]{4, 9, 6, 10}));
    }
}
