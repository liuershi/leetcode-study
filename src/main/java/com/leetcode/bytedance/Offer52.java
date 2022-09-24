package com.leetcode.bytedance;

/**
 * @author zhangwei151
 * @date 2022/9/24 23:02
 */
public class Offer52 {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 思路一：使用容器存储某个链表的原因，然后再遍历另一个链表判断是否有元素已存在
        // 时间复杂度：O(n + m) 空间复杂度：O(n)
        // 简单，不实现

        // 思路二：分别遍历两个链表，若在某一时刻两个元素相同则返回，否则从另一个链表头
        // 开始遍历，因为如果两个链表有相交，则一定会在某个节点相遇
        // 时间复杂度：O(1) 空间复杂度：O(1)
        if (headA == null || headB == null) return null;
        ListNode nextA = headA, nextB = headB;
        while (nextA != nextB) {
            nextA = nextA == null ? headB : nextA.next;
            nextB = nextB == null ? headA : nextB.next;
        }
        return nextA;
    }
}
