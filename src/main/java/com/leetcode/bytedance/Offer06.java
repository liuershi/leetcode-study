package com.leetcode.bytedance;

import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/8/5 12:30 上午
 * @Version 1.0
 */
public class Offer06 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public int[] reversePrint(ListNode head) {
//        return method01(head);

        // 1.获取链表长度
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        // 2.再次遍历
        cur = head;
        int[] nums = new int[len--];
        while (cur != null) {
            nums[len--] = cur.val;
            cur = cur.next;
        }
        return nums;
    }

    private int[] method01(ListNode head) {
        if (head == null || head.next == null)
            return head == null ? new int[]{} : new int[]{head.val};
        int len = 0;
        // 先快慢指针获取当前链表总长度
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            len += 2;
        }
        if (fast != null) len++;

        int[] nums = new int[len--];
        while (head != null) {
            nums[len--] = head.val;
            head = head.next;
        }
        return nums;
    }
}
