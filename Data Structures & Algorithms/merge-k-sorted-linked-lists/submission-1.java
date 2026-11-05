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
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;
    
    int interval = 1;
    while (interval <= lists.length) {
      for (int i=0; i+interval < lists.length; i = i + (2*interval)) {
        lists[i] = this.merge2SortedLists(lists[i], lists[i+interval]);
      }
      interval *= 2;
    }
    return lists[0];
  }
  
  public ListNode merge2SortedLists(ListNode l1, ListNode l2) {
    ListNode dummyNode = new ListNode(); ListNode dummyCurr = dummyNode;
    ListNode l1Curr = l1; ListNode l2Curr = l2;
    
    while ((l1Curr!=null) && (l2Curr!=null)) {
      if (l1Curr.val <= l2Curr.val) {
        dummyCurr.next = l1Curr;
        l1Curr = l1Curr.next; dummyCurr = dummyCurr.next;
      } else {
        dummyCurr.next = l2Curr;
        l2Curr = l2Curr.next; dummyCurr = dummyCurr.next;
      }
    }
    
    if (l1Curr != null ) {
      dummyCurr.next = l1Curr;
    } else {
      dummyCurr.next = l2Curr;
    }
    
    return dummyNode.next;
  }
}
