package com.leetcode.zcy.graph;

/**
 * @Author milindeyu
 * @Date 2022/3/29 11:08 下午
 * @Version 1.0
 */
public class Edge {
    // 线的权重
    private int weight;

    private Node from;

    private Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
