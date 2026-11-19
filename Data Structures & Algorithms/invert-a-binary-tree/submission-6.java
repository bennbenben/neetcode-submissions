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
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }

    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.offerFirst(root);
    
    while (!stack.isEmpty()) {
      TreeNode node = stack.pollFirst();
      
      TreeNode tempNode = node.left;
      node.left = node.right;
      node.right = tempNode;
      
      if (node.right != null) { // enqueue the right before left for next iteration
        stack.offerFirst(node.right);
      }
      
      if (node.left != null) {
        stack.offerFirst(node.left);
      }
      
    }
    
    return root;
  }
}
