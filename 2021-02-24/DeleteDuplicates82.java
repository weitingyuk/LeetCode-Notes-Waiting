package Leetcode;

public class DeleteDuplicates82 {

  /**Method: Iteration + dummy node; Time:O(N); Space: O(1) **/
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = dummy;
    while(cur.next != null && cur.next.next != null) {
      if(cur.next.val == cur.next.next.val) {
        ListNode temp = cur.next;
        while (temp != null && temp.next != null && temp.val == temp.next.val) {
          temp = temp.next;
        }
        cur.next = temp.next;
      } else {
        cur = cur.next;
      }
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
