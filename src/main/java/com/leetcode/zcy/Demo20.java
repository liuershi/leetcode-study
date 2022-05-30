package com.leetcode.zcy;

/**
 * 获取指定二叉树的链路的最大长度，每个节点只能走一次
 *
 * @Author milindeyu
 * @Date 2022/4/26 1:32 上午
 * @Version 1.0
 */
public class Demo20 {

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Info {
        int height; // 左侧或右侧不包含头节点的最大长度
        int maxDistance; // 头节点左侧或右侧的最大链路距离

        public Info(int height, int maxDistance) {
            this.height = height;
            this.maxDistance = maxDistance;
        }
    }

    public static Info maxLengthTree(Node node) {
        if (node == null) {
            return new Info(0, 0);
        }
        Info lInfo = maxLengthTree(node.left);
        Info rInfo = maxLengthTree(node.right);

        // info
        int lMaxDistance = lInfo.maxDistance;
        int rMaxDistance = rInfo.maxDistance;
        int height = lInfo.height + rInfo.height + 1; // 因为要包含头节点，所以加1
        int maxDistance = Math.max(height, Math.max(lMaxDistance, rMaxDistance));
        return new Info(maxDistance, Math.max(lInfo.height, rInfo.height) + 1);
    }
}
