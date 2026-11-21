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
  private int maxSum = 0;
  
  public int maxPathSum(TreeNode root) {
    this.maxSum = Integer.MIN_VALUE; // handling for negative numbers
    this.dfsRecursive(root);
    return this.maxSum;
  }
  
  private int dfsRecursive(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    int leftSum = Math.max(0, this.dfsRecursive(root.left)); // if a branch is negative, clamp to 0
    int rightSum = Math.max(0, this.dfsRecursive(root.right));
    
    int Vmax = root.val + leftSum + rightSum;
    this.maxSum = Math.max(this.maxSum, Vmax);
    
    return Math.max(root.val + leftSum, root.val + rightSum);
  }}
