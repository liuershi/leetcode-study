package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/28 5:50 下午
 * @Version 1.0
 */
public class Demo86 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        // 借助虚拟节点
        ListNode virtualLowNode = new ListNode(0);
        ListNode virtualHeightNode = new ListNode(0);
        ListNode searchVirtualLowNode = virtualLowNode;
        ListNode searchVirtualHeightNode = virtualHeightNode;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (head.val < x) {
                searchVirtualLowNode.next = head;
                searchVirtualLowNode = searchVirtualLowNode.next;
            } else {
                searchVirtualHeightNode.next = head;
                searchVirtualHeightNode = searchVirtualHeightNode.next;
            }
            head = next;
        }
        searchVirtualLowNode.next = virtualHeightNode.next;
        return virtualLowNode.next;
    }

    public static void main(String[] args) {
        Demo86 demo86 = new Demo86();
        ListNode node = new ListNode(2, new ListNode(1));
        System.out.println(demo86.partition(node, 1));
    }
}
