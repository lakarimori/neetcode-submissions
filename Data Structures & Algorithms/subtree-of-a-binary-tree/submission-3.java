/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) {\ this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (checkSubtree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean checkSubtree(TreeNode subtree, TreeNode subRoot) {
        if (subtree == null && subRoot == null) {
            return true;
        }

        if ((subtree == null && subRoot != null) || (subtree != null && subRoot == null) || (subtree.val != subRoot.val)) {
            return false;
        }

        return checkSubtree(subtree.left, subRoot.left) && checkSubtree(subtree.right, subRoot.right);
    }
}