package com.leetcode.bytedance;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/7/24 3:36 下午
 * @Version 1.0
 */
public class Demo142 {
    
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
//        return method1(head);
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 当快慢指针在环上相遇时。后续只需要慢指针和头节点一步一步移动相遇则为环的第一个节点
            if (slow == fast) {
                while (slow != head) {
                    slow = slow.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }

    /**
     * 时间和空间复杂度都为 O(n)
     * @param head
     * @return
     */
    private ListNode method1(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        ListNode cur = head;
        while (cur != null) {
            if (!set.add(cur)) return cur;
            cur = cur.next;
        }
        return null;
    }
}
