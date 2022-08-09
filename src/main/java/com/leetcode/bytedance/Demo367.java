package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/18 10:26 下午
 * @Version 1.0
 */
public class Demo367 {

    public boolean isPerfectSquare(int num) {
        return method3(num);
    }

    /**
     * 二分法时间复杂度为 log(n)
     * @param num
     * @return
     */
    private boolean method3(int num) {
        // 使用二分法实现
        int left = 0, right = num;
        while (left <= right) {
            // 取中间值的时候注意溢出
            int middle = left + (right - left) / 2;
            // 计算乘积的时候也要注意溢出
            long val = (long) middle * middle;
            if (val == num) return true;
            else if (val > num) right = middle - 1;
            else left = middle + 1;
        }
        return false;
    }

    /**
     * 时间复杂度较高为 O(num的开方)
     * @param num
     * @return
     */
    private boolean method2(int num) {
        // 如果num为平方数，那么num则为连续n个奇数的和
        // 也即：1 + 3 + 5 + ... + (2n - 1) = n * n;
        int index = 1, val = 0;
        while (val < num && val >= 0) { // 判断val大于0是因为其可能溢出
            val += 2 * index++ - 1;
        }
        return val == num;
    }

    /**
     * 使用Java库函数判断
     * @param num
     * @return
     */
    private boolean method1(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
