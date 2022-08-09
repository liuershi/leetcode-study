package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/13 7:05 下午
 * @Version 1.0
 */
public class Demo237 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {
        if (node == null) return;
        // 题目保证了删除节点不为头或尾节点
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
