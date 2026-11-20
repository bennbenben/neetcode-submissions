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
    public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    int maxDiameter = 0;
    
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.offerFirst(root);
    Map<TreeNode, Integer> depthMap = new HashMap<TreeNode, Integer>();
    depthMap.put(null, 0);
    
    while (!stack.isEmpty()) {
      TreeNode headNode = stack.peekFirst();
      
      // if both child nodes is already process before
      if (depthMap.containsKey(headNode.left) && depthMap.containsKey(headNode.right)) {
        headNode = stack.pollFirst();
        
        int vShapedDiameter = depthMap.get(headNode.left) + depthMap.get(headNode.right);
        maxDiameter = Math.max(maxDiameter, vShapedDiameter);
        
        depthMap.put(headNode, 1 + Math.max(depthMap.get(headNode.left), depthMap.get(headNode.right)));
        
      } else { // one or more of child nodes not processed before
        if (!depthMap.containsKey(headNode.right)) {
          stack.offerFirst(headNode.right);
        }
        
        if (!depthMap.containsKey(headNode.left)) {
          stack.offerFirst(headNode.left);
        }
      }
    }

    return maxDiameter;
  }
}
