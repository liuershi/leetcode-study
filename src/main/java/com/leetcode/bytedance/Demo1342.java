package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/10/15 9:18 下午
 * @Version 1.0
 */
public class Demo1342 {

    public int numberOfSteps(int num) {
        int step = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                num--;
            } else num >>= 1;
            step++;
        }
        return step;
    }
}
