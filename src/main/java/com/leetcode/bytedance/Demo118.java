package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/5/30 11:55 下午
 * @Version 1.0
 */
public class Demo118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rsp = new ArrayList<>(numRows);
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    list.add(1);
                } else {
                    List<Integer> prev = rsp.get(i - 2);
                    int val = prev.get(j - 1) + prev.get(j);
                    list.add(val);
                }
            }
            rsp.add(list);
        }
        return rsp;
    }

    public static void main(String[] args) {
        Demo118 demo118 = new Demo118();
        System.out.println(demo118.generate(5));
    }
}
