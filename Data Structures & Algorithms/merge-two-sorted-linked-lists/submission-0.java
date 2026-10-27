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
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(); ListNode dummyCurr = dummy;
    ListNode list1Curr = list1; ListNode list2Curr = list2; 
    
    while ((list1Curr!=null) && (list2Curr!=null)) {
      if (list1Curr.val <= list2Curr.val) {
        dummyCurr.next = list1Curr;
        dummyCurr = dummyCurr.next;
        list1Curr = list1Curr.next;
      } else {
        dummyCurr.next = list2Curr;
        dummyCurr = dummyCurr.next;
        list2Curr = list2Curr.next;
      }
    }
    
    if (list1Curr!=null) {
      dummyCurr.next=list1Curr;
    } else {
      dummyCurr.next=list2Curr;
    }
    
    return dummy.next;
  }
}