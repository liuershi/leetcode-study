package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/28 5:02 下午
 * @Version 1.0
 */
public class Demo82 {

    
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode rsp = null;
        ListNode prev = null;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                ListNode nextDiff = findNextDiff(head.next);
                if (prev != null)
                    prev.next = nextDiff;
                head = nextDiff;
            } else {
                if (rsp == null)
                    rsp = head;
                prev = head;
                head = head.next;
            }
        }
        return rsp;
    }

    private ListNode findNextDiff(ListNode node) {
          ListNode currentNode = node;
        while (currentNode.next != null && currentNode.val == currentNode.next.val) {
            currentNode = currentNode.next;
        }
        return node.val == currentNode.val ? null : currentNode;
    }
}
