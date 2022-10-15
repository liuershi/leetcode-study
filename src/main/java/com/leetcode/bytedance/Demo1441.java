package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/10/15 8:08 下午
 * @Version 1.0
 */
public class Demo1441 {

    public List<String> buildArray(int[] target, int n) {
        List<String> rsp = new ArrayList<>(target.length);
        int current = 1;
        for (int i = 0; i < target.length; i++) {
            if (target[i] != current) {
                while (current <= target[i]) {
                    rsp.add("Push");
                    if (current < target[i])
                        rsp.add("Pop");
                    current++;
                }
            } else rsp.add("Push");
            current++;
        }
        return rsp;
    }
}
