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
  // DFS - Recursive, In-order (left, root, right); Optimized
  private int k;
  private int count;
  private int result;
  public int kthSmallest(TreeNode root, int k) {
    this.k = k;
    this.count = 0;
    this.result = -1;
    this.inOrderDfsRecursiveOptimized(root);
    return this.result;
  }
  
  private void inOrderDfsRecursiveOptimized(TreeNode root) {
    if (root == null) {
      return;
    }
    this.inOrderDfsRecursiveOptimized(root.left);
    
    this.count += 1;
    if (this.count == k) {
      this.result = root.val;
      return;
    }
    
    if (this.count < k) {
      this.inOrderDfsRecursiveOptimized(root.right);
    }
  }
}
