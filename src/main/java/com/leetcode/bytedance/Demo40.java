package com.leetcode.bytedance;


import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/5/20 11:17 下午
 * @Version 1.0
 */
public class Demo40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> rsp = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, rsp, list, 0);
        return rsp;
    }

    /**
     *
     * @param candidates 给定数组
     * @param current 当前值
     * @param rsp 结果集
     * @param list 可能集合
     */
    private void dfs(int[] candidates, int current, List<List<Integer>> rsp, LinkedList<Integer> list, int begin) {
        if (current < 0) return;
        if (current == 0) {
            rsp.add(new ArrayList<>(list));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            // 重点 i > begin，这个是保证同一层级上只保留一个相同节点处理
            if (i > begin && candidates[i] == candidates[i - 1])
                continue;
            int candidate = candidates[i];
            int subValue = current - candidate;
            if (subValue < 0)
                break;

            list.addLast(candidate);
            dfs(candidates, subValue, rsp, list, i + 1);
            list.removeLast();
        }
    }


    public static void main(String[] args) {
        Demo40 demo40 = new Demo40();
        int[] nums = {10,1,2,7,6,1,5};
        int target = 8;
        demo40.combinationSum2(nums, target);
    }
}
