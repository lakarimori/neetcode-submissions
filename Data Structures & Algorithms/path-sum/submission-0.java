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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return pathSum(root, targetSum, 0);
    }

    private boolean pathSum(TreeNode node, int target, int currentSum) {
        currentSum += node.val;
        if (node.left == null && node.right == null) {
            return currentSum == target;
        }

        boolean leftResult = false;
        boolean rightResult = false;

        if (node.left != null) {
            leftResult = pathSum(node.left, target, currentSum);
        }
        
        if (node.right != null) {
            rightResult = pathSum(node.right, target, currentSum);
        }

        return leftResult || rightResult;
    }
}