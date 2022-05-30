package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 汉诺塔问题
 *
 * @Author milindeyu
 * @Date 2022/4/18 11:33 下午
 * @Version 1.0
 */
public class Demo0806 {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        C.addAll(A);
    }

    public static void main(String[] args) {

        Demo0806 demo0806 = new Demo0806();
        List<Integer> A = Arrays.asList(2, 1, 0);
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        demo0806.hanota(A, B, C);
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
    }
}
