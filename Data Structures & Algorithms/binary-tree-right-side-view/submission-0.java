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
  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) {
      return new ArrayList<Integer>();
    }
    
    TreeNode node = root;
    Queue<TreeNode> treeQueue = new LinkedList<>();
    treeQueue.add(node);
    List<Integer> rightSideVals = new ArrayList<Integer>();
    
    while (!treeQueue.isEmpty()) {
      int nodesInLevel = treeQueue.size();
      
      for (int i=0; i<nodesInLevel; i++) {
        if (nodesInLevel - i == 1) {
          node = treeQueue.peek();
          rightSideVals.add(node.val);
        }
        
        node = treeQueue.poll();
        if (node != null && node.left != null) {
          treeQueue.offer(node.left);
        }
        if (node != null && node.right != null) {
          treeQueue.offer(node.right);
        }
        
      }
    }
    
    return rightSideVals;
  }
}
