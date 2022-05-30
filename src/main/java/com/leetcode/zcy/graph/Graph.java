package com.leetcode.zcy.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author milindeyu
 * @Date 2022/3/29 11:13 下午
 * @Version 1.0
 */
public class Graph {
    // 当前图包含的节点信息
    private HashMap<Integer, Node> node;

    // 当前图包含的线信息
    private HashSet<Edge> edges;

    public Graph() {
        this.node = new HashMap<>();
        this.edges = new HashSet<>();
    }
}
