package Leetcode;

public class ReverseBetween92 {

  /** Method: Recursion; Times:O(N); Space:N(1) **/
  /**
   * 使用三个指针： pre, cur, next
   * 先将 curr 的下一个节点记录为 next；
   * 执行操作 ①：把 curr 的下一个节点指向 next 的下一个节点；
   * 执行操作 ②：把 next 的下一个节点指向 pre 的下一个节点；
   * 执行操作 ③：把 pre 的下一个节点指向 next。
   */
  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode pre = dummy;
    for(int i = 0; i< left-1; i++) {
      pre = pre.next;
    }
    ListNode cur = pre.next;
    for(int i=left; i<right;i++) {
      ListNode nextp = cur.next;
      cur.next = nextp.next;
      nextp.next = pre.next;
      pre.next = nextp;
    }
    return dummy.next;
  }

  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
