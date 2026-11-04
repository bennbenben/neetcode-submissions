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
    PriorityQueue<ListNode> mergeKHeap = new PriorityQueue<ListNode>((a,b) -> a.val - b.val);
    for (ListNode node : lists) {
      if (node == null) {
        continue;
      }
      mergeKHeap.offer(node);
    }
    
    ListNode dummyNode = new ListNode();
    ListNode dummyCurr = dummyNode;
    while (!mergeKHeap.isEmpty()) {
      ListNode minNode = mergeKHeap.poll();
      dummyCurr.next = minNode;
      dummyCurr = dummyCurr.next;
      if (minNode.next != null) {
        mergeKHeap.offer(minNode.next);
      }
    }
    
    return dummyNode.next;
  }
}
