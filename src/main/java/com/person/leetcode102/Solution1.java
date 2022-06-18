package com.person.leetcode102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root != null) {
            Queue<TreeNodeLayer> queue = new LinkedList<>();
            queue.add(new TreeNodeLayer(1, root));

            while (!queue.isEmpty()) {
                TreeNodeLayer treeNodeLayer = queue.remove();
                int layer = treeNodeLayer.layer;
                TreeNode treeNode = treeNodeLayer.treeNode;

                if (result.size() != layer) {
                    result.add(new ArrayList<>());
                }

                result.get(layer - 1).add(treeNode.val);

                if (treeNode.left != null)
                    queue.add(new TreeNodeLayer(layer + 1, treeNode.left));
                if (treeNode.right != null)
                    queue.add(new TreeNodeLayer(layer + 1, treeNode.right));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Object test = new Solution1().levelOrder(tree);
        System.out.println(test);
    }
}
