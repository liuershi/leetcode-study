package com.leetcode.bytedance;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @Author milindeyu
 * @Date 2022/3/19 6:08 下午
 * @Version 1.0
 */
public class Demo160 {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        return method1(headA, headB);

        // 此种方式的时间和空间的复杂度都为O(1)
        if (headA == null || headB == null) return null;
        ListNode nextA = headA, nextB = headB;
        while (nextA != nextB) {
            nextA = nextA == null ? headB : nextA.next;
            nextB = nextB == null ? headA : nextB.next;
        }
        return nextA;
    }

    /**
     * 时间和空间复杂度都为O(m + n)
     * @param headA
     * @param headB
     * @return
     */
    private ListNode method1(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null || headB != null) {
            if (headA != null) {
                if (set.contains(headA)) return headA;
                set.add(headA);
                headA = headA.next;
            }
            if (headB != null) {
                if (set.contains(headB)) return headB;
                set.add(headB);
                headB = headB.next;
            }
        }
        return null;
    }
}
