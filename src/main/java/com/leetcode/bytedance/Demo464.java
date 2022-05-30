package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/22 3:18 下午
 * @Version 1.0
 */
public class Demo464 {

    private int max;


    /**
     * 未实现
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        this.max = maxChoosableInteger;

        boolean[] selected = new boolean[desiredTotal + 1];
        return first(selected, desiredTotal) || !sec(selected, desiredTotal);
    }

    private boolean first(boolean[] selected, int total) {
        if (total <= 0) return false;
        for (int i = 1; i <= max; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            total -= i;
            if (total <= 0) return true;
            return sec(selected, total);
        }
        return false;
    }

    private boolean sec(boolean[] selected, int total) {
        if (total <= 0) return true;
        for (int i = 1; i <= max; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            total -= i;
            if (total <= 0) return false;
            return first(selected, total);
        }
        return true;
    }
}
