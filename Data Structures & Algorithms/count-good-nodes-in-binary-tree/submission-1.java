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

                2
            n       4
                10      8
            n       n       4
 */

class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int goodNodes = 0;
        Queue<Pair<TreeNode,Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(root, Integer.MIN_VALUE));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int maxval = pair.getValue();

            if (node.val >= maxval) {
                goodNodes++;
            }

            if (node.left != null) {
                queue.offer(new Pair<>(node.left, Math.max(maxval, node.val)));
            }

            if (node.right != null) {
                queue.offer(new Pair<>(node.right, Math.max(maxval, node.val)));
            }
        }

        return goodNodes;
    }
}
