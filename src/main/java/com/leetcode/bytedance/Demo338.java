package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/20 11:08 下午
 * @Version 1.0
 */
public class Demo338 {

    public int[] countBits(int n) {
        int[] rsp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            rsp[i] = bitCount(n); // 最优实现为 Integer.bitCount()
        }
        return rsp;
    }

    /**
     * 通过右移计算最后一位数是否为1来判断
     * 时间复杂度：O(n)
     * @param n
     * @return
     */
    public int bitCount(int n) {
        int count = 0;
        do {
            if ((n & 1) == 1) count++;
           n >>= 1;
        } while (n > 0);
        return count;
    }

    /**
     * 在方法一的基础上优化
     * 时间复杂度也为 O(n) , 不过极端情况下才会复杂度和方法一相同
     * @param n
     * @return
     */
    public int bitCount2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }

    /**
     * 参考 {@link Integer#bitCount(int)}
     * @param n
     * @return
     */
    public int bitCount3(int n) {
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
        n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);
        return n;
    }

    public int bitCount4(int n) {
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 0x3f;
    }
}
