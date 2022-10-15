package com.leetcode.bytedance;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/10/12 10:20 下午
 * @Version 1.0
 */
public class Demo817 {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int rsp = 0;
        ListNode prev = null;
        while (head != null) {
            if (set.contains(head.val)
                && (prev == null || !set.contains(prev.val))) rsp++;
            prev = head;
            head = head.next;
        }
        return rsp;
    }
}
