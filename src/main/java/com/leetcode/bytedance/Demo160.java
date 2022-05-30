package com.leetcode.bytedance;

import java.util.List;
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
     * todo 有问题？当前解法错误
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }
        int length = Math.min(stackA.size(), stackB.size());
        ListNode current = null;
        for (int i = 0; i < length; i++) {
            ListNode popA = stackA.pop();
            ListNode popB = stackB.pop();
            if (popA.val != popB.val) {
                break;
            }
            current = popA;
        }
        return current;
    }
}
