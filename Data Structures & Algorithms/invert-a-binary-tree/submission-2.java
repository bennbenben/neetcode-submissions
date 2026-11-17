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
    
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll(); // head of queue
      
      // swap the left and right of most recently added node
      TreeNode temp = node.left; 
      node.left = node.right;
      node.right = temp;
      
      // add the children into queue for next iteration
      if (node.right != null) {
        queue.offer(node.right);
      } 
      
      if (node.left != null) {
        queue.offer(node.left);
      } 
    }
    
    return root;
  }
}
