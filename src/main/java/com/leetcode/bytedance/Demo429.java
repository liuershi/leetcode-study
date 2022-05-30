package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/4/8 10:03 下午
 * @Version 1.0
 */
public class Demo429 {

    class Node {
        int val;
        List<Node> children;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    private List<List<Integer>> result = new ArrayList<>();
    private Map<Integer, List<Integer>> map = new LinkedHashMap<>();

    public List<List<Integer>> levelOrder(Node root) {
        int level = 0;
        process(root, level);
        result.addAll(map.values());
        return result;
    }

    private void process(Node root, int level) {
        if (root == null) return;
        ++level;
        List<Integer> list = map.get(level);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(root.val);
        map.put(level, list);
        for (Node child : root.children) {
            process(child, level);
        }
    }
}
