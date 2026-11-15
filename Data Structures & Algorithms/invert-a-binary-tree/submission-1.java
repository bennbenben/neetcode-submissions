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
      TreeNode node = stack.pollFirst(); // get the most recently added node
      
      TreeNode temp = node.left;
      node.left = node.right;
      node.right = temp;
      
      if (node.right!=null) {
        stack.addFirst(node.right);
      }
      
      if (node.left!=null) {
        stack.addFirst(node.left);
      }
    }
    
    return root;
  }

}
