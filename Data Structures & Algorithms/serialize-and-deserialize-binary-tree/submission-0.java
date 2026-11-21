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

  // DFS - Recursive, encodes tree to a single string  
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    this.serializeDfsRecursiveMethod(root, sb);
    return sb.toString();
  }
  
  private void serializeDfsRecursiveMethod(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append("null");
      sb.append(",");
      return;
    }
    
    sb.append(root.val).append(",");
    this.serializeDfsRecursiveMethod(root.left, sb);
    this.serializeDfsRecursiveMethod(root.right, sb);
  }
  
  // DFS - Recursive, decode string to Tree  
  private int deserializeDfsRecursiveIndex = 0;
  
  public TreeNode deserialize(String data) {
    if (data.equals("null") || data.isEmpty()) {
      return null;
    }
    this.deserializeDfsRecursiveIndex = 0;
    String[] deserializeString = data.split(",");
    TreeNode node = this.deserializeDfsRecursiveMethod(deserializeString);
    return node;
  }
  
  private TreeNode deserializeDfsRecursiveMethod(String[] data) {
    String currentValue = data[deserializeDfsRecursiveIndex]; 
    this.deserializeDfsRecursiveIndex += 1;
    
    if (!currentValue.equals("null")) {
      TreeNode node = new TreeNode(Integer.valueOf(currentValue)); 
      node.left = this.deserializeDfsRecursiveMethod(data);
      node.right = this.deserializeDfsRecursiveMethod(data);
      return node;  
    
    } else {
      return null;
    }
  }
}
