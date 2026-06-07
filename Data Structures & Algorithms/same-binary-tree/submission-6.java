/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            System.out.println("comparing first: " + first.val);
            System.out.println("comparing second: " + second.val);

            if (first.val != second.val) {
                return false;
            }

            if (first.left != null && second.left != null) {
                queue.offer(first.left);
                queue.offer(second.left);
            } else if ((first.left != null && second.left == null) 
            || (first.left == null && second.left != null)) {
                return false;
            }

            if (first.right != null && second.right != null) {
                queue.offer(first.right);
                queue.offer(second.right);
            } else if ((first.right != null && second.right == null) 
            || (first.right == null && second.right != null)) {
                return false;
            }
        }

        return true;
    }
}
