package Leetcode;

public class DeleteDuplicates83 {
  /**Method: Iteration; Time:O(N); Space: O(1) **/
  public ListNode deleteDuplicates(ListNode head) {
    ListNode node = head;
    while(node != null && node.next != null) {
      if(node.val == node.next.val) {
        node.next = node.next.next;
      } else {
        node = node.next;
      }
    }
    return head;
  }

   //Definition for singly-linked list.
   public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}
