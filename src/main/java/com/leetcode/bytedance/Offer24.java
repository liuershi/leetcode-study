package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/31 10:51 下午
 * @Version 1.0
 */
public class Offer24 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        return helper(head, null);
    }

    private ListNode helper(ListNode node, ListNode prev) {
        if (node.next == null) {
            node.next = prev;
            return node;
        }
        // 注意：需要先获取下个元素再赋值，避免被覆盖后递归调用是引用错误
        ListNode next = node.next;
        node.next = prev;
        return helper(next, node);
    }
}
