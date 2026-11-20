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
  public class TreePair {
    private TreeNode node;
    private Integer depth;
    public TreePair(TreeNode node, Integer depth) {
      this.node = node;
      this.depth = depth;
    }
  }

  // BFS - Iterative
  public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    
    Queue<TreePair> queue = new LinkedList<Solution.TreePair>();
    queue.offer(new TreePair(root, 1));
    
    int maxDepth = 0;
    
    while (!queue.isEmpty()) {
      TreePair treePair = queue.poll();
      maxDepth = Math.max(maxDepth, treePair.depth);
      
      if (treePair.node.left != null) {
        TreePair treePairLeft = new TreePair(treePair.node.left, treePair.depth+1);
        queue.offer(treePairLeft);
      }
      
      if (treePair.node.right != null) {
        TreePair treePairRight = new TreePair(treePair.node.right, treePair.depth+1);
        queue.offer(treePairRight);
      }
    }
    
    return maxDepth;
  }
}
