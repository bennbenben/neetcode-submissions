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
  // DFS - Recusive
  private int countGoodNodes = 0;
  
  public int goodNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    this.countGoodNodes = 0;
    this.dfsRecursive(root, root.val);
    return this.countGoodNodes;
  }
  
  private void dfsRecursive(TreeNode node, int maxSoFar) {
    if (node == null) {
      return;
    }
    
    if (node.val >= maxSoFar) {
      this.countGoodNodes += 1;
    }
    
    int newMaxSoFar = Math.max(maxSoFar, node.val);
    
    this.dfsRecursive(node.left, newMaxSoFar);
    this.dfsRecursive(node.right, newMaxSoFar);
  }
}
