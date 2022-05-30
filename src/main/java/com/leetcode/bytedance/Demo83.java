package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/28 5:08 下午
 * @Version 1.0
 */
public class Demo83 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode rsp = head;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                ListNode currentNode = head.next;
                while (currentNode != null && currentNode.val == head.val) {
                    currentNode = currentNode.next;
                }
                head.next = currentNode;
                head = currentNode;
            } else {
                head = head.next;
            }
        }

        return rsp;
    }
}
