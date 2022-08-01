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
//        return method1(head);
        // 基于迭代实现，时间复杂度为O(N)，空间复杂度为O(1)，相对递归的方式少了递归调用的开销
        if (head == null || head.next == null) return null;
        ListNode prev = null, next = head.next;
        while (next != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 基于递归实现
     * @param head
     * @return
     */
    private ListNode method1(ListNode head) {
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
