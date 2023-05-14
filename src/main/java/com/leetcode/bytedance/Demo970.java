package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2023/5/2 11:33 下午
 * @Version 1.0
 */
public class Demo970 {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
//        return method1(x, y, bound);
        Set<Integer> ans = new HashSet<>();
        for (int i = 1; i < bound; i *= x) {
            for (int j = 1; i + j <= bound; j *= y) {
                ans.add(i + j);
                if (y == 1) {
                    // 如果此时y为1，那么只需要计算一次，因为不管多少次方y的值总为1
                    break;
                }
            }
            // 同理，如果x为1，那么不管x的多少次方也一定为1，那么此时上面已经计算过一次了，不需要再计算了
            if (x == 1) {
                break;
            }
        }
        return new ArrayList<>(ans);
    }

    private ArrayList<Integer> method1(int x, int y, int bound) {
        int max = 100;
        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i <= max; i++) {
            int pre = (int) Math.pow(x, i);
            if (pre >= bound) {
                break;
            }
            for (int j = 0; j <= max; j++) {
                int val = (int) (pre + Math.pow(y, j));
                if (val > bound) {
                    break;
                }
                ans.add(val);
            }
        }
        return new ArrayList<>(ans);
    }
}
