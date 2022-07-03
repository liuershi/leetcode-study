package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/6/20 10:51 下午
 * @Version 1.0
 */
public class Demo386 {

    List<Integer> rsp;
    public List<Integer> lexicalOrder(int n) {
        rsp = new ArrayList<>(n);

        for (int i = 1; i <= 9; i++) {
            dfs(i, n);
        }
        return rsp;
    }

    private void dfs(int val, int n) {
        if (val > n) return;

        rsp.add(val);
        for (int i = 0; i <= 9; i++) {
            int nextVal = val * 10 + i;
            if (nextVal > n) return;
            dfs(nextVal, n);
        }
    }
}
