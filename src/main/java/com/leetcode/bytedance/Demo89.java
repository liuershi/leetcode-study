package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/5/28 11:23 下午
 * @Version 1.0
 */
public class Demo89 {

    /**
     * 格雷码：https://baike.baidu.com/item/%E6%A0%BC%E9%9B%B7%E7%A0%81/6510858
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> rsp = new ArrayList<>();
        rsp.add(0);
        for (int i = 0; i < n; i++) {
            int val = 1 << i;
            int size = rsp.size();
            for (int j = size - 1; j >= 0; j--) {
                rsp.add(rsp.get(j) | val);
            }
        }
        return rsp;
    }
}
