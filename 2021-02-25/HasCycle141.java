package Leetcode;


public class HasCycle141 {
  /*Method : Two pointers, Time: O(N), Space:O(1)**/
  public boolean hasCycle(ListNode head) {
    if(head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = slow.next;
    while (slow != fast) {
      if(fast == null || fast.next == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return true;
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
