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
  private boolean isSameTree(TreeNode p, TreeNode q) { // solution from another question - SameBinaryTree
    if (p == null && q == null) { // end of traversal
      return true;
    }
    
    if (p == null || q == null) { // check for null values. earlier just checked if both are nulls
      return false;
    }
    
    if (p.val != q.val) { // check value
      return false;
    }
    
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 
  }

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null) {
      return false;
    }

    if (this.isSameTree(root, subRoot)) {
      return true;  
    }

    return this.isSubtree(root.left, subRoot) || this.isSubtree(root.right, subRoot);
  }
}
