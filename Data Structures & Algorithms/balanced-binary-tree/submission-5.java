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
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.offerFirst(root);
    
    Map<TreeNode, Integer> depthMap = new HashMap<TreeNode, Integer>();
    depthMap.put(null, 0);
    
    while (!stack.isEmpty()) {
      TreeNode headNode = stack.peekFirst();
      TreeNode leftChild = headNode.left; TreeNode rightChild = headNode.right;
      
      if (depthMap.containsKey(leftChild) && depthMap.containsKey(rightChild)) {
        headNode = stack.pollFirst();
        int leftChildHeight = depthMap.get(leftChild); int rightChildHeight = depthMap.get(rightChild);
        depthMap.put(headNode, 1+Math.max(leftChildHeight, rightChildHeight));
        
        if (Math.abs(leftChildHeight - rightChildHeight) > 1) {
          return false;
        }
        
      } else {
        if (!depthMap.containsKey(rightChild)) {
          stack.offerFirst(rightChild);
        }
        
        if (!depthMap.containsKey(leftChild)) {
          stack.offerFirst(leftChild);
        }
      }
    }
    
    return true;
  }
}
