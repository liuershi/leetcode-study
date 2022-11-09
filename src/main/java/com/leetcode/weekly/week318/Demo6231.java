package com.leetcode.weekly.week318;

import com.leetcode.bytedance.Demo623;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Author milindeyu
 * @Date 2022/11/6 11:25 上午
 * @Version 1.0
 */
public class Demo6231 {

    public long totalCost(int[] costs, int k, int candidates) {
        int left = candidates, right = costs.length - candidates;
        TreeSet<Node> set = new TreeSet<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val == o2.val ? o1.idx - o2.idx : o1.val - o2.val;
            }
        });
        for (int i = 0; i < left; i++) {
            set.add(new Node(i, costs[i]));
        }
        for (int i = right; i < costs.length; i++) {
            set.add(new Node(i, costs[i]));
        }

        long cost = 0;
        while (k-- > 0) {
            Node node = set.first();
            System.out.println(node.val);
            set.remove(node);
            cost += node.val;
            if (node.idx < left && left < right) {
                set.add(new Node(left, costs[left]));
                left++;
            } else if (right > left){
                right--;
                set.add(new Node(right, costs[right]));
            }
        }
        return cost;
    }

    class Node {
        private int idx;
        private int val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Demo6231 demo6231 = new Demo6231();
        int[] costs = {31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58};
        System.out.println(demo6231.totalCost(costs, 11, 2));
    }
}
