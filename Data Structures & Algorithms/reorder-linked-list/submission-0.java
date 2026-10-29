/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
  public void reorderList(ListNode head) {
    ListNode slowNode = head; ListNode fastNode = head;
    
    while ((fastNode != null) && (fastNode.next != null)) {
      slowNode = slowNode.next;
      fastNode = fastNode.next.next;
    }
    ListNode midNode = slowNode.next; slowNode.next = null;
    
    ListNode prev = null; ListNode curr = midNode;
    while (curr != null) {
      ListNode nextNode = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextNode;
    }
    
    while ((head!=null) && (prev!=null)) {
      ListNode nextHead = head.next;
      ListNode nextPrev = prev.next;
      
      head.next = prev;
      head.next.next = nextHead;
      
      head = nextHead;
      prev = nextPrev;
    }
  }

}
