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
  private int preOrderIndex=0;
  private Map<Integer, Integer> inOrderMap = new HashMap<Integer, Integer>();
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    for (int i=0; i<inorder.length; i++) {
      this.inOrderMap.put(inorder[i], i);
    }
    return this.buildTreeHelper(preorder, 0, inorder.length - 1);
  }

  private TreeNode buildTreeHelper(int[] preorder, int inOrderLeft, int inOrderRight) {
    if (inOrderLeft > inOrderRight) {
      return null;
    }
    
    int rootValue = preorder[this.preOrderIndex]; this.preOrderIndex += 1;
    TreeNode rootNode = new TreeNode(rootValue);
    
    int inOrderRootIndex = this.inOrderMap.get(rootValue);

    rootNode.left = this.buildTreeHelper(preorder, inOrderLeft, inOrderRootIndex-1);
    rootNode.right = this.buildTreeHelper(preorder, inOrderRootIndex+1, inOrderRight);

    return rootNode;
  }
}
