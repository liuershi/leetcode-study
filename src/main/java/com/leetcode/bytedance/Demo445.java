package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2023/7/3 12:10 上午
 * @Version 1.0
 */
public class Demo445 {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] nums1 = new int[101];
        int[] nums2 = new int[101];
        int idx1 = 1, idx2 = 1;
        while (l1 != null) {
            nums1[idx1++] = l1.val;
            l1 = l1.next;
        }
        while (l2 != null) {
            nums2[idx2++] = l2.val;
            l2 = l2.next;
        }

        boolean is1 = idx1 >= idx2;
        int inc = 0;
        int count = Math.max(idx1, idx2);
        while (idx1 > 0 || idx2 > 0 || inc != 0) {
            if (idx1 > 0) {
                inc += nums1[--idx1];
            }
            if (idx2 > 0) {
                inc += nums2[--idx2];
            }

            if (is1) {
                nums1[idx1] = inc % 10;
            } else {
                nums2[idx2] = inc % 10;
            }
            inc /= 10;
        }

        ListNode root = new ListNode();
        ListNode node = root;
        int[] nums = is1 ? nums1 : nums2;
        for (int i = 0; i < count; i++) {
            if (i == 0 && nums[i] == 0) {
                continue;
            }
            node.next = new ListNode(nums[i]);
            node = node.next;
        }
        return root.next;
    }
}
