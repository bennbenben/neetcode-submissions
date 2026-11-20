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
  public boolean isSameTree(TreeNode p, TreeNode q) {
    Queue<TreeNode[]> treeStack = new LinkedList<TreeNode[]>();
    treeStack.offer(new TreeNode[] {p,q});
    
    while (!treeStack.isEmpty()) {
      TreeNode[] nodesArray = treeStack.poll();
      TreeNode nodeP = nodesArray[0]; TreeNode nodeQ = nodesArray[1];
      
      if (nodeP == null && nodeQ == null) { // end of traversal
        continue;
      }
      
      if (nodeP == null || nodeQ == null) { // earlier checked both are not null, if any true here means false
        return false;
      }
      
      if (nodeP.val != nodeQ.val) { // check values
        return false;
      }
      
      TreeNode[] childLeftNodesArray = new TreeNode[] {nodeP.left, nodeQ.left};
      treeStack.offer(childLeftNodesArray);
      
      TreeNode[] childRightNodesArray = new TreeNode[] {nodeP.right, nodeQ.right};
      treeStack.offer(childRightNodesArray);
    }
    
    return true;
  }
}
