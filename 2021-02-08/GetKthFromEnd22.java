package Leetcode;

public class GetKthFromEnd22 {
  /** Method: Two pointers； Space: O(1)； Time: O(N)； **/
  public ListNode getKthFromEnd1(ListNode head, int k) {
    ListNode fast = head, slow = head;
    while(k-- >0) {
      fast = fast.next;
    }
    while(fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }

  /** Method: Recursive； Space: O(1)； Time: O(N)； **/
  int size;
  public ListNode getKthFromEnd2(ListNode head, int k) {
    if(head == null) {
      return null;
    }
    ListNode node = getKthFromEnd2(head.next, k);
    if (++size == k) {
      return head;
    }
    return node;
  }

  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
