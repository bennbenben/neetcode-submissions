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
  private class TreePair {
    private TreeNode node;
    private int depth;
    private TreePair (TreeNode node, int depth) {
      this.node = node;
      this.depth = depth;
    }
  }

  // DFS - Iterative
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    Deque<TreePair> stack = new LinkedList<Solution.TreePair>();
    stack.offerFirst(new TreePair(root, 1));
    
    int maxDepth = 0;
    
    while (!stack.isEmpty()) {
      
      TreePair treePair = stack.pollFirst();
      maxDepth = Math.max(treePair.depth, maxDepth);
      
      if (treePair.node.right != null) {
        TreePair treePairRight = new TreePair(treePair.node.right, treePair.depth+1);
        stack.offerFirst(treePairRight);
      }
      
      if (treePair.node.left != null) {
        TreePair treePairLeft = new TreePair(treePair.node.left, treePair.depth+1);
        stack.offerFirst(treePairLeft);
      }
      
    }
    return maxDepth;
  }
}
