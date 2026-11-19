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
  // DFS - Recursive
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int maxEdge = Math.max(this.maxDepth(root.left), this.maxDepth(root.right));
    return 1 + maxEdge;
  }
}
