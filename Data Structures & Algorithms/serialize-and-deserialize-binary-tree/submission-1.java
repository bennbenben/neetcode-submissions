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

public class Codec {

// Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    Queue<TreeNode> serializeQueue = new LinkedList<TreeNode>();
    serializeQueue.offer(root);
    StringBuilder sbTree = new StringBuilder();
    
    while (!serializeQueue.isEmpty()) {
      TreeNode node = serializeQueue.poll();
      
      if (node != null) {
        sbTree.append(node.val).append(",");
        serializeQueue.offer(node.left); 
        serializeQueue.offer(node.right);
      } else {
        sbTree.append("null").append(",");
      }
    }
    
    return sbTree.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.equals("null,") || data.isEmpty()) {
      return null;
    }
    
    String[] dataValues = data.split(",");
    
    Queue<TreeNode> deserializeQueue = new LinkedList<TreeNode>();
    TreeNode rootNode = new TreeNode(Integer.valueOf(dataValues[0]));
    deserializeQueue.offer(rootNode);
    int i=1;
    
    while (!deserializeQueue.isEmpty()) {
      TreeNode node = deserializeQueue.poll();
      
      if (dataValues[i].equals("null")) {
        i += 1;
      } else {
        TreeNode leftChildNode = new TreeNode(Integer.valueOf(dataValues[i]));
        node.left = leftChildNode;
        deserializeQueue.offer(leftChildNode);
        i += 1;
      }
      
      if (dataValues[i].equals("null")) {
        i += 1;
      } else {
        TreeNode rightChildNode = new TreeNode(Integer.valueOf(dataValues[i]));
        node.right = rightChildNode;
        deserializeQueue.offer(rightChildNode);
        i += 1;
      }
      
      
    }
    
    return rootNode;
  }
}
