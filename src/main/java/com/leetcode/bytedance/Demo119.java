package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/5/31 12:10 上午
 * @Version 1.0
 */
public class Demo119 {

    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> rsp = new ArrayList<>(rowIndex);
        List<Integer> prev;
        for (int i = 1; i <= rowIndex; i++) {
            prev = new ArrayList<>(rsp);
            rsp.clear();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1)
                    rsp.add(1);
                else {
                    int val = prev.get(j - 1) + prev.get(j);
                    rsp.add(val);
                }
            }
        }
        return rsp;
    }

    public static void main(String[] args) {
        Demo119 demo119 = new Demo119();
        System.out.println(demo119.getRow(3));
    }
}
