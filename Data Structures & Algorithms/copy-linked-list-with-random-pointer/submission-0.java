/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
  public Node copyRandomList(Node head) {
    Node originalNode = head; 
    Map<Node, Node> nodesMap = new HashMap<Node, Node>();
    
    while (originalNode != null) {
      Node copyNode = new Node(originalNode.val);
      nodesMap.put(originalNode, copyNode);
      originalNode = originalNode.next;
    }
    
    originalNode = head; 
    while (originalNode != null) {
      Node copyNode = nodesMap.get(originalNode);
      
      // assign next node
      copyNode.next = nodesMap.get(originalNode.next);
      copyNode.random = nodesMap.get(originalNode.random);
      originalNode = originalNode.next;
    }
    
    return nodesMap.get(head);
  }}
