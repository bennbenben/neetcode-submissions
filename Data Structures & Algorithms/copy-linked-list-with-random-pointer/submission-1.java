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
    if (head == null) return null;
    Node originalNode = head;
    
    // transform A -> B -> C into A -> A' -> B -> B' -> C -> C'
    while (originalNode!=null) {
      Node copyNode = new Node(originalNode.val);
      Node nextNode = originalNode.next;
      originalNode.next = copyNode; copyNode.next = nextNode;
      originalNode = nextNode;
    }
    
    // transform copied nodes' .random pointers A -> A' -> B -> B' -> C -> C'
    originalNode = head;
    while (originalNode!=null) {
      Node copyNode = originalNode.next;
      if (originalNode.random == null) {
        copyNode.random = null;
      } else {
        copyNode.random = originalNode.random.next;
      }
      originalNode = copyNode.next;
    }
    
    // unzip A -> A' -> B -> B' -> C -> C' into A -> B -> C and A' -> B' -> C'
    originalNode = head; Node copyHead = originalNode.next;
    while (originalNode!=null) {
      Node copyNode = originalNode.next;
      
      if (copyNode.next != null) {
         originalNode.next = copyNode.next;
         copyNode.next = copyNode.next.next; // or originalNode.next.next
      } else {
        originalNode.next = null;
        copyNode.next = null;
      }
      
      originalNode = originalNode.next;
    }
    return copyHead;
  }
}
