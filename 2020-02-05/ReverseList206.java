package Leetcode;

public class ReverseList206 {

  /** Method1:iteration, Time: O(N), Space:O(1)**/
  public ListNode reverseList1(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while(cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }

  /** Method1:iteration, Time: O(N), Space:O(1)**/
  public ListNode reverseList2(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while(cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }

  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

}
