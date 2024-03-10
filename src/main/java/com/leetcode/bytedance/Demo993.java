package com.leetcode.bytedance;

import javax.swing.*;
import java.util.LinkedList;

/**
 * @Author milindeyu
 * @Date 2024/2/8 10:57 下午
 * @Version 1.0
 */
public class Demo993 {
    
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    



    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        LinkedList<TreeNode> container = new LinkedList<>();
        container.addLast(root);
        int found = 0;
        TreeNode xParent = null, yParent = null;
        while (!container.isEmpty()) {
            int size = container.size();
            while (size-- > 0) {
                TreeNode node = container.pollFirst();
                if (node.left != null) {
                    container.offerLast(node.left);
                    if (node.left.val == x || node.left.val == y) {
                        found++;
                        xParent = node;
                    }
                }
                if (node.right != null) {
                    container.offerLast(node.right);
                    if (node.right.val == y || node.right.val == x) {
                        found++;
                        yParent = node;
                    }
                }

                if (found == 2 && xParent != yParent) {
                    return true;
                }
            }

            found = 0;
        }
        return false;
    }
}
