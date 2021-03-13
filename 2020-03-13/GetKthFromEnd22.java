package Leetcode;

public class GetKthFromEnd22 {
  /** Method: Two pointers； Space: O(1)； Time: O(N)； **/
  public ListNode getKthFromEnd(ListNode head, int k) {
    ListNode pre = head;
    ListNode cur = head;
    for(int i=0; i < k; i++) {
      cur = cur.next;
    }
    while(cur != null ) {
      pre = pre.next;
      cur = cur.next;
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
