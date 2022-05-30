package com.leetcode.zcy.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/3/29 11:08 下午
 * @Version 1.0
 */
public class Node {
    // 当前节点的值
    private int val;
    // 向当前节点的线数量
    private int in;
    // 从当前节点发散出去的线数量
    private int out;
    // 从当前节点的节点集合
    private List<Node> nexts;
    // 出当前节点的线集合
    private List<Edge> deges;

    public Node(int val) {
        this.val = val;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.deges = new ArrayList<>();
    }
}
