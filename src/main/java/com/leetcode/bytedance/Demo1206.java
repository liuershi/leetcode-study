package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

/**
 * 设计跳表
 * @author zhangwei151
 * @date 2022/7/28 15:49
 */
public class Demo1206 {

    class SkipNode {
        // 当前节点值
        int val;
        // 当前节点的右节点和下节点
        SkipNode right, down;

        public SkipNode(int val) {
            this.val = val;
        }
    }

    // 虚拟节点
    SkipNode head;
    // 随机生成0和1，新增节点时决定是否向上插入节点
    Random random;
    // 最大的索引层级
    final int MAX_LEVEL = 32;
    // 当前索引层级
    int heightLevel;

    public Demo1206() {
        this.head = new SkipNode(-1);
        this.random = new Random();
    }

    public boolean search(int target) {
        SkipNode node = head;
        while (node != null) {
            if (node.val == target) return true;
            else if (node.right == null || node.right.val > target) node = node.down;
            else node = node.right;
        }
        return false;
    }

    public void add(int num) {
        Deque<SkipNode> stack = new ArrayDeque<>();
        SkipNode node = head;
        while (node != null) {
            if (node.right == null) {
                stack.push(node);
                node = node.down;
            } else if (node.right.val < num) node = node.right;
            else {
                stack.push(node);
                node = node.down;
            }
        }

        int level = 1; // 当前层数，从第一层开始
        // 自底向上新增节点
        SkipNode addNode, downNode = null;
        while (!stack.isEmpty()) {
            node = stack.pop();
            addNode = new SkipNode(num);
            addNode.down = downNode;
            downNode = addNode;
            if (node.right == null) { // 说明新增在链表结尾
                node.right = addNode;
            } else {
                // 否则新增节点插入到当前节点和其右节点中间
                addNode.right = node.right;
                node.right = addNode;
            }
            // 考虑是否向上新增节点
            if (level > MAX_LEVEL) break;

            // 随机生成0和1，一半的概率决定是否向上新增节点
            if ((random.nextInt(2) & 1) == 0) break;
            level++;

            if (level > heightLevel) {
                heightLevel = level;
                SkipNode newHead = new SkipNode(this.head.val);
                newHead.down = head;
                head = newHead;
                stack.push(newHead);
            }
        }
    }

    public boolean erase(int num) {
        SkipNode node = head;
        boolean deleted = false;
        while (node != null) {
            if (node.right == null) node = node.down;
            else if (node.right.val == num) {
                deleted = true;
                node.right = node.right.right;
                node = node.down;
            } else if (node.right.val < num) node = node.right;
            else node = node.down;
        }
        return deleted;
    }
}
