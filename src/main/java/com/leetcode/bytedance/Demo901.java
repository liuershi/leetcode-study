package com.leetcode.bytedance;

import java.util.*;

/**
 * @author zhangwei151
 * @date 2022/10/21 9:22
 */
public class Demo901 {

    /**
     * 思路：单调栈
     */
    class StockSpanner {

        class Node {
            int key;
            int val;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        Deque<Node> stack;

        public StockSpanner() {
            this.stack = new ArrayDeque<>();
        }

        public int next(int price) {
            if (stack.isEmpty() || stack.peek().key > price) {
                stack.push(new Node(price, 1));
                return 1;
            }
            Node node;
            int val = 1;
            while (!stack.isEmpty() && stack.peek().key <= price) {
                node = stack.pop();
                val += node.val;
            }
            Node addNode = new Node(price, val);
            stack.push(addNode);
            return val;
        }
    }
}
