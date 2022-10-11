package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/10/11 10:27 下午
 * @Version 1.0
 */
public class Demo797 {

    int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.n = graph.length;
        List<List<Integer>> rsp = new ArrayList<>();
        process(0, new LinkedList<Integer>(), graph, rsp);
        return rsp;
    }

    private void process(int index, LinkedList<Integer> path, int[][] graph, List<List<Integer>> rsp) {
        // 每次调用先将下标放入路径
        path.addLast(index);
        if (index == this.n - 1) {
            rsp.add(new ArrayList<>(path));
            return;
        }
        for (int idx : graph[index]) {
            process(idx, path, graph, rsp);
            // 当一次调用链路结束后移除最后元素
            path.removeLast();
        }
    }
}
