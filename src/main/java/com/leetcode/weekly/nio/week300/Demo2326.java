package com.leetcode.weekly.nio.week300;

import java.util.Arrays;
import java.util.List;

/**
 *
 * https://leetcode.cn/contest/weekly-contest-300/problems/spiral-matrix-iv/
 *
 * @Author milindeyu
 * @Date 2022/8/8 11:24 下午
 * @Version 1.0
 */
public class Demo2326 {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int m, n;
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] rsp = new int[m][n];
        this.m = m;
        this.n = n;
        for (int[] nums : rsp) {
            Arrays.fill(nums, -1);
        }
        helper(0, 0, rsp, 0, head);
        return rsp;
    }

    private void helper(int m, int n, int[][] rsp, int direction, ListNode node) {
        if (node == null) return;
        rsp[m][n] = node.val;
        node = node.next;

        int nextM = m + this.directions[direction][0];
        int nextN = n + this.directions[direction][1];

        if (nextM >= this.m || nextM < 0 || nextN >= this.n || nextN < 0 || rsp[nextM][nextN] != -1) {
            direction = (direction + 1) % 4;
        }
        m += directions[direction][0];
        n += directions[direction][1];
        helper(m, n, rsp, direction, node);

    }
}
