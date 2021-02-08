package Leetcode;

public class ReverseBetween92 {
  boolean stop = false;
  private ListNode left;
  /**Method: Recursion; Times:O(N); Space:O(N-M) **/
  public ListNode reverseBetween1(ListNode head, int m, int n) {
    left = head;
    stop = false;
    recurseAndReverse(head, m, n);
    return head;
  }
  private void recurseAndReverse (ListNode right, int m, int n) {
    if(n == 1){
      return;
    }
    right = right.next;
    if(m>1) {
      left = left.next;
    }
    recurseAndReverse(right, m-1, n-1);
    if(left==right || right.next ==left) {
      stop = true;
    }
    if(!stop) {
      int t=left.val;
      left.val = right.val;
      right.val = t;
      left = left.next;
    }
  }

  /**Method: Iteration; Times:O(N); Space:N(1) **/
  public ListNode reverseBetween2(ListNode head, int m, int n) {
    if(head == null) {
      return null;
    }
    ListNode cur = head, pre = null;
    while(m>1){
      pre = cur;
      cur = cur.next;
      m--;
      n--;
    }
    ListNode conn = pre, tail = cur;
    ListNode third = null;
    while(n>0) {
      third = cur.next;
      cur.next = pre;
      pre = cur;
      cur = third;
      n--;
    }
    if(conn != null) {
      conn.next = pre;
    } else {
      head = pre;
    }
    tail.next = cur;
    return head;
  }

  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
