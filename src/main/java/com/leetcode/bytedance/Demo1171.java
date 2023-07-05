package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/6/11 12:09 下午
 * @Version 1.0
 */
public class Demo1171 {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return null;
        }
        int sum = 0;
       for (ListNode cur = head; cur != null; cur = cur.next) {
           if ((sum += cur.val) == 0) {
               return removeZeroSumSublists(cur.next);
           }
       }
        head.next = removeZeroSumSublists(head.next);
        return head;
    }
}
