package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/6/12 10:07 下午
 * @Version 1.0
 */
public class Demo133 {


    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return dfs(node);
    }

    public Node dfs(Node node) {
        // 获取不到时创建一个默认的节点
        Node copy = map.getOrDefault(node.val, new Node());
        // 若为默认节点时
        if (copy.val == 0) {
            copy.val = node.val;
            map.put(copy.val, copy);
            for (Node neighbor : node.neighbors) {
                copy.neighbors.add(dfs(neighbor));
            }
        }
        return copy;
    }
}
