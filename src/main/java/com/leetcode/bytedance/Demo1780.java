package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/12/10 12:23 上午
 * @Version 1.0
 */
public class Demo1780 {

    public boolean checkPowersOfThree(int n) {
        // 思路：如果一个数可以表示为3的幂的和，那么这个数转换为三进制后
        // 数只可能存在0和1
        // 例如：12 ==> 110， 21 ==> 210
        while (n > 0) {
            if (n % 3 == 2)
                return false;
            n /= 3;
        }
        return true;
    }
}
