package com.leetcode.weekly.week324;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/12/18 10:45 上午
 * @Version 1.0
 */
public class Demo6266 {

    public int smallestValue(int n) {
        int val = n;
        while (val != (val = resolvePrime(val))) {

        }
        return val;
    }

    public int resolvePrime(int num) {

        // 定义结果字符串缓存对象，用来保存结果字符
        int sum = 0;

        // 定义最小素数
        int i = 2;

        // 进行辗转相除法
        while (i <= num) {

            // 若num 能整除 i ，则i 是num 的一个因数
            if (num % i == 0) {

                // 将i 保存进sb 且 后面接上 *
                sum += i;

                // 同时将 num除以i 的值赋给 num
                num = num / i;

                // 将i重新置为2
                i = 2;
            } else {

                // 若无法整除，则i 自增
                i++;
            }
        }

        return sum;
    }
}
