package com.leetcode.bytedance;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author milindeyu
 * @Date 2022/6/25 4:47 下午
 * @Version 1.0
 */
public class Demo559 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        // 方式二：宽度优先遍历实现
        int depth = 0;
        if (root == null) return depth;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node node = queue.poll();
                if (!node.children.isEmpty()) {
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }
            depth++;
        }
        return depth;
    }
}
