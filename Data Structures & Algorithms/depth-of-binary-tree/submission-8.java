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
  // BFS - Optimized
  public int maxDepth(TreeNode root) {
    
    if (root == null) return 0;
    
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    
    int maxDepth = 0;
    int numOfNodesInLevel = 0;
    
    while (!queue.isEmpty()) {
      maxDepth += 1;
      numOfNodesInLevel = queue.size();
      for (int i=0; i<numOfNodesInLevel; i++) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
    }
    
    return maxDepth;
  }
}
