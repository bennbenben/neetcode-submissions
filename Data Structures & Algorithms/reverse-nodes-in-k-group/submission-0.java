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
  public ListNode reverseKGroup(ListNode head, int k) { 
    ListNode headNode = head; int countNodes = 0;
    while (headNode != null) {
      countNodes += 1;
      headNode = headNode.next;    
    }
    
    int groupNodes = countNodes/k; int nodeGroupCount=0;
    headNode = head;
    ListNode dummyHead = new ListNode(); dummyHead.next = headNode;
    ListNode groupDummyHead = dummyHead;
    while (nodeGroupCount < groupNodes) {
      ListNode nextGroupHead = headNode;
      for (int i=0; i<k; i++) {
        nextGroupHead = nextGroupHead.next;
      }
      
      ListNode prev = null; 
      ListNode curr = headNode;
      for (int i=0; i<k; i++) {
        ListNode nextNode = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextNode;
      }
      
      groupDummyHead.next = prev;
      headNode.next = nextGroupHead;
      groupDummyHead = headNode;
      headNode = nextGroupHead;
      
      nodeGroupCount+=1;
    }
    
    return dummyHead.next;
  }
}
