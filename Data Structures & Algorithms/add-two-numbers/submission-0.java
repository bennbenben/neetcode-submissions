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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode firstHead = l1; ListNode secondHead = l2;
    ListNode dummy = new ListNode(); ListNode additionHead = dummy;
    
    int carry = 0;
    int remainder = 0;
    while ((firstHead != null) && (secondHead != null)) {
      remainder = (firstHead.val + secondHead.val + carry)%10;
      carry = (firstHead.val + secondHead.val + carry)/10;
      additionHead.next = new ListNode(remainder);
      
      firstHead = firstHead.next;
      secondHead = secondHead.next;
      additionHead = additionHead.next;
    }
    
    while (firstHead != null) {
      remainder = (firstHead.val + carry)%10;
      carry = (firstHead.val + carry)/10;
      additionHead.next = new ListNode(remainder);

      firstHead = firstHead.next;
      additionHead = additionHead.next;
    }
    
    while (secondHead != null) {
      remainder = (secondHead.val + carry)%10;
      carry = (secondHead.val + carry)/10;
      additionHead.next = new ListNode(remainder);

      secondHead = secondHead.next;
      additionHead = additionHead.next;
    }
    
    if (carry != 0) {
      additionHead.next = new ListNode(carry);
    }

    return dummy.next;
  }
}
