package Leetcode;


public class SwapPairs24 {

  /**Method: Loop + dummy node; Time:O(N); Space: O(1) **/
  public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode cur = dummy;
    while(cur.next != null && cur.next.next != null) {
      ListNode n1 = cur.next;
      ListNode n2= cur.next.next;
      cur.next = n2;
      n1.next = n2.next;
      n2.next = n1;
      cur = n1;
    }
    return dummy.next;
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
