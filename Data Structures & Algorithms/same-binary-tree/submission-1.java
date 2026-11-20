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
  // DFS - Iterative
  public boolean isSameTree(TreeNode p, TreeNode q) {
    Deque<TreeNode[]> treeStack = new LinkedList<TreeNode[]>();
    treeStack.offerFirst(new TreeNode[] {p,q});
    
    while (!treeStack.isEmpty()) {
      TreeNode[] nodesArray = treeStack.pollFirst();
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
      
      TreeNode[] childRightNodesArray = new TreeNode[] {nodeP.right, nodeQ.right};
      treeStack.offerFirst(childRightNodesArray);
      
      TreeNode[] childLeftNodesArray = new TreeNode[] {nodeP.left, nodeQ.left};
      treeStack.offerFirst(childLeftNodesArray);
    }
    
    return true;
  }
}
