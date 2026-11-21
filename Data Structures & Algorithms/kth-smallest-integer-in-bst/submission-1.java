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
    // DFS - Recursive, in-order (left, root, right)
    private List<Integer> bstValuesList = new ArrayList<Integer>();

    public int kthSmallest(TreeNode root, int k) {
        this.inOrderDfsRecursive(root);
        this.bstValuesList.sort((a,b) -> Integer.compare(a,b));
        return this.bstValuesList.get(k-1);
    }

    private void inOrderDfsRecursive(TreeNode root) {
       if (root == null) {
        return;
       }
       this.inOrderDfsRecursive(root.left);
       this.bstValuesList.add(root.val);
       this.inOrderDfsRecursive(root.right);
    }


}
