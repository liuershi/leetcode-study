package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2024/1/6 12:42 下午
 * @Version 1.0
 */
public class Demo2807 {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode prev = head, cur = head.next;
        while(cur != null) {
            int gcd = gcd(prev.val, cur.val);
            ListNode node = new ListNode(gcd);
            prev.next = node;
            node.next = cur;
            prev = cur;
            cur = cur.next;
        }
        return head;
    }

    /**
     * 最大公约数
     *
     * @param first     第一个数
     * @param second    第二个数
     * @return
     */
    private int gcd(int first, int second) {
        int divisor = 0;
        while((divisor = first % second) != 0) {
            first = second;
            second = divisor;
        }
        return second;
    }
}
