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
  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    return this.dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }
  
  private boolean dfs(TreeNode root, long lowLim, long highLim) {
    if (root == null) {
      return true;
    }
    
    if (lowLim >= root.val || root.val >= highLim) {
      return false;
    }
    
    return dfs(root.left, lowLim, root.val) && dfs(root.right, root.val, highLim);
  }
}
