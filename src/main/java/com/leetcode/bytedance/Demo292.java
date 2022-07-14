package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/13 10:59 下午
 * @Version 1.0
 */
public class Demo292 {

    public boolean canWinNim(int n) {
        return firstFun(n) || !secFun(n);
    }

    public boolean firstFun(int n) {
        if (n < 4) return true;
        boolean rsp = false;
        for (int i = 1; i <= 3; i++) {
            rsp |= secFun(n - i);
        }
        return !rsp;
    }

    public boolean secFun(int n) {
        if (n < 4) return true;
        boolean rsp = false;
        for (int i = 1; i <= 3; i++) {
            rsp |= firstFun(n - i);
        }
        return !rsp;
    }
}
