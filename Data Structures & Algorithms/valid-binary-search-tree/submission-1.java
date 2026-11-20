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
  // BFS - Iterative
  private record Node(TreeNode root, long minBound, long maxBound) {}

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    
    Queue<Node> queue = new LinkedList<Node>();
    queue.offer(new Node(root, Long.MIN_VALUE, Long.MAX_VALUE));
    
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (node.minBound < node.root.val && node.root.val < node.maxBound) {
        if (node.root.left != null) {
          Node leftChildNode = new Node(node.root.left, node.minBound, node.root.val);
          queue.offer(leftChildNode);
        }
        
        if (node.root.right != null) {
          Node rightChildNode = new Node(node.root.right, node.root.val, node.maxBound);
          queue.offer(rightChildNode);
        }
        
      } else {
        return false;
      }
    }
    
    return true;
  }
}
