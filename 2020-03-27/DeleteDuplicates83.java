package Leetcode;

public class DeleteDuplicates83 {
  /**Method: Iteration; Time:O(N); Space: O(1) **/
  public ListNode deleteDuplicates(ListNode head) {
    ListNode cur = head; //从head开始
    while(cur != null && cur.next != null) { //是cur 和 next对比
      if(cur.val == cur.next.val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
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
