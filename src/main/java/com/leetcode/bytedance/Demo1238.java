package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2023/2/23 12:17 上午
 * @Version 1.0
 */
public class Demo1238 {

    public List<Integer> circularPermutation(int n, int start) {
        // 思路：类似格雷编码
        List<Integer> res = new ArrayList<Integer>(){{ add(start); }};

        int head = 1;
        for (int i = 0; i < n; i++) {
            int size = res.size();
            for (int j = size - 1; j >= 0; j--) {
                // (res.get(j) ^ start) : 这部分相当于还原到上一阶的res.get(j)
                // 然后再 ｜head 相当于在值的最前面加二进制1
                // 最后再与start按位异或
                int val = ((res.get(j) ^ start) | head) ^ start;
                res.add(val);
            }
            head <<= 1;
        }

        return res;
    }

    public List<Integer> circularPermutation2(int n, int start) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(start);
        for (int i = 1; i <= n; i++) {
            int m = ret.size();
            for (int j = m - 1; j >= 0; j--) {
                ret.add(((ret.get(j) ^ start) | (1 << (i - 1))) ^ start);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Demo1238 demo1238 = new Demo1238();
        System.out.println(demo1238.circularPermutation(2, 3));
        System.out.println(demo1238.circularPermutation2(2, 3));
    }
}
