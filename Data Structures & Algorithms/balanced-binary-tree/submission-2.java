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
// DFS - Recursive O(N) version
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (this.dfsRecursiveOptimized(root) == -1) {
      return false;
    } else {
      return true;
    }
  }

  private int dfsRecursiveOptimized(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    int leftHeight = this.dfsRecursiveOptimized(root.left);
    int rightHeight = this.dfsRecursiveOptimized(root.right);
    
    if (leftHeight == -1 || rightHeight == -1) {
      return -1;
    }
    
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    } else {
      return 1 + Math.max(leftHeight, rightHeight);
    }
  }
}
