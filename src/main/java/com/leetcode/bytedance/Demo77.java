package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/5/25 10:23 下午
 * @Version 1.0
 */
public class Demo77 {

    private int len;

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rsp = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        len = n;
        traceBack(new LinkedList<>(), nums, k, rsp, 0);

        return rsp;
    }

    private void traceBack(LinkedList<Integer> list, int[] nums, int k, List<List<Integer>> rsp, int begin) {
        if (list.size() == k) {
            rsp.add(new ArrayList<>(list));
            return;
        }
        // i 小于选择上界的值，总结起来就是：搜索起点的上界 + 接下来要选择的元素个数 - 1 = n
        // @see https://leetcode.cn/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/

        for (int i = begin; i < len - (k - list.size()) + 1; i++) {
            list.addLast(nums[i]);
            traceBack(list, nums, k, rsp, i + 1);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        Demo77 demo77 = new Demo77();
        demo77.combine(5, 3);
    }
}
