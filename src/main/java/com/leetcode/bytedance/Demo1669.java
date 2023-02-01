package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/1/30 7:22 下午
 * @Version 1.0
 */
public class Demo1669 {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = list1;
        ListNode cur = list1, prev = dummyNode;
        int idx = 0;
        while (cur != null) {

            if (idx == a) {
                prev.next = list2;
            }
            if (idx == b) {;
                while (true) {
                    if (list2.next == null) {
                        list2.next = cur.next;
                        break;
                    }
                    list2 = list2.next;
                }
                break;
            }

            prev = cur;
            cur = cur.next;
            idx++;
        }

        return dummyNode.next;
    }
}
